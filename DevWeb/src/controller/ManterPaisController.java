package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/ConsultaPais.do")
public class ManterPaisController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("name");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");

		int id = -1;
		int pop = -1;
		int area = -1;
		try {
			id = Integer.parseInt(pId);
			pop = Integer.parseInt(pPopulacao);
			area = Integer.parseInt(pArea);
		} catch (NumberFormatException e) {

		}

		// Instanciando JavaBean
		Pais pais = new Pais();

		pais.setId(id);
		pais.setNome(pNome);
		pais.setPopulacao(pop);
		pais.setArea(area);

		// Instanciando o service
		PaisService pServ = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		// Enviar para jsp
		if (pAcao.equals("Criar")) {
			pServ.criar(pais);
			ArrayList<Pais> lista = new ArrayList<>();
			lista.add(pais);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarPaises.jsp");

		} else if (pAcao.equals("Excluir")) {
			pServ.excluir(pais.getId());
			ArrayList<Pais> lista = (ArrayList<Pais>) session.getAttribute("lista");
			lista.remove(busca(pais, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarPaises.jsp");

		} else if (pAcao.equals("Alterar")) {
			pServ.atualizar(pais);
			ArrayList<Pais> lista = (ArrayList<Pais>) session.getAttribute("lista");
			int p = busca(pais, lista);
			lista.remove(p);
			lista.add(p, pais);
			session.setAttribute("lista", lista);
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("VisualizarPais.jsp");

		} else if (pAcao.equals("Visualizar")) {
			pais = pServ.carregar(pais.getId());
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("VisualizarPais.jsp");

		} else if (pAcao.equals("Editar")) {
			pais = pServ.carregar(pais.getId());
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("AlterarPais.jsp");

		}

		// Recebendo o request da jsp
		view.forward(request, response);

	}

	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pais.getId()) {
				return i;
			}
		}
		return -1;
	}
}
