package br.edu.ifms.loja.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.loja.dao.ComputadorDAO;
import br.edu.ifms.loja.modelo.Computador;

@WebServlet("/public")
public class ComputadorControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ComputadorDAO computadorDAO;
	
    public ComputadorControle() {
        super();
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
			case "novo":
				novoComputador(request, response);
				break;
			case "inserir":
				gravarComputador(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void novoComputador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("public/public-new-computer.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void gravarComputador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String marca = request.getParameter("marca");
		String memoria = request.getParameter("memoria");
		String preco = request.getParameter("preco");
		
		Computador computador = new Computador(marca, Integer.parseInt(memoria), Double.parseDouble(preco));
		
		computadorDAO.inserirComputador(computador);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("public/public-new-computer.jsp");
		request.setAttribute("mensagem", "Usuário cadastrado com sucesso");
		dispatcher.forward(request, response);
	}

}
