package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/ConsultaPais.do")
public class PaisController extends HttpServlet {

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pnome = request.getParameter("name");
		int pPopulacao = Integer.parseInt(request.getParameter("populacao"));
		int parea = Integer.parseInt(request.getParameter("area"));
		
		// Instanciando JavaBean
		Pais pais = new Pais();
		
		pais.setNome(pnome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(parea);
		
		// Instanciando o service
		PaisService pServ = new PaisService();
		pServ.criar(pais);
		pais = pServ.carregar(pais.getId());
		
		// Enviar para jsp
		request.setAttribute("pais", pais);
		
		// Recebendo o request da jsp
		RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");
		view.forward(request, response);
		
	}
}
