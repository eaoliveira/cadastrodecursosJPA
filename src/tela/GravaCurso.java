package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.CursoDao;
import model.Curso;
import model.Endereco;

@WebServlet("/gravaCurso")
public class GravaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CursoDao dao;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Curso cur  = new Curso();
		cur.setNome(request.getParameter("nome"));
		cur.setDescricao(request.getParameter("descricao"));
		
		dao.adiciona(cur);
		
		Mensagem msg = new Mensagem();
		msg.setTitulo("Sucesso");
		msg.setTexto("Sucesso na Inclus�o");
		msg.setUrl("listaCurso");
		
		request.getSession().setAttribute("count", dao.contadorCurso());
		request.getSession().setAttribute("msg", msg);
		response.sendRedirect("resultPage2.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
