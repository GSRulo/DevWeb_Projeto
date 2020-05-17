package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {

	// CRIAR
	public int criar(Pais pais) {
		String sql = "INSERT INTO paises(id, nome, populacao, area) VALUES (default,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());

			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ATUALIZAR
	public void atualizar(Pais pais) {
		String sql = "UPDATE paises SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DELETAR
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM paises WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pais carregar(int id) {
		Pais pais = new Pais();
		pais.setId(id);
		String sqlSelect = "SELECT * FROM paises WHERE paises.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} else {
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(0);
					pais.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}

	public void maiorPopulacao(Pais pais) {
		String sqlSelect = "SELECT * FROM paises WHERE populacao = ( SELECT MAX(populacao) FROM paises )";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) {
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void menorArea(Pais pais) {
		String sqlSelect = "SELECT * FROM paises WHERE area = ( SELECT MIN(area) FROM paises )";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) {
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Pais> vetorTresPaises() {
		String sqlSelect = "SELECT * FROM paises LIMIT 3";
		ArrayList<Pais> arrayPais = new ArrayList<>();

		try (Connection conn = ConnectionFactory.obtemConexao(); Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) {
				arrayPais.add(
						new Pais(rs.getInt("id"), rs.getString("nome"), rs.getLong("populacao"), rs.getDouble("area")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayPais;
	}

}
