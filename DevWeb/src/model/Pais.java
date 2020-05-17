package model;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;

	public Pais() {
	}

	public Pais(int id, String nome, long populacao, double area) {
		this.setId(id);
		this.setNome(nome);
		this.setPopulacao(populacao);
		this.setArea(area);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "País [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	};

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (area == 0) {
			if (other.area != 0)
				return false;
		} else if (area != other.area)
			return false;
		if (populacao == 0) {
			if (other.populacao != 0)
				return false;
		} else if (populacao != other.populacao)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}