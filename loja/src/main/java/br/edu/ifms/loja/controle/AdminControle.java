package br.edu.ifms.loja.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.loja.dao.ComputadorDAO;
import br.edu.ifms.loja.modelo.Computador;

@WebServlet("/auth/admin")
public class AdminControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComputadorDAO computadorDAO;
    
	
    public AdminControle() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	computadorDAO = new ComputadorDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	protected void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "listar":
				listarComputador(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listarComputador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Computador> computadores = computadorDAO.listarComputadores();
		request.setAttribute("listaComputadores", computadores);
		
		String path = request.getServletPath() + "/admin-listar-computador.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);
	}

}
