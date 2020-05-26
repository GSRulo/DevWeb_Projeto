package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		
		pais = pServ.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");
		
		view.forward(request, response);

	}

}
