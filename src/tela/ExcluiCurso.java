package tela;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.CursoDao;

@WebServlet("/excluiCurso")
public class ExcluiCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger("ExcluiCurso");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensagem msg = new Mensagem();
		String[] ids = request.getParameterValues("curid");

		CursoDao dao = CursoDao.getInstance();
		
		if (ids == null) {
			msg.setTexto("Não existe item selecionado!");
		} else {
			boolean houveFalha = false;
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				if(!dao.delCurso(id)) {
					houveFalha = true;
					log.log(Level.WARNING, "houve falha na exclusão");
					break;
				}
			}
			if(!houveFalha)
				msg.setTexto("Excluido(s) com sucesso");
			else
				msg.setTexto("O Curso não existe!");
		}
		
		int count = dao.contadorCurso();
		
		if(count > 0) {
			msg.setUrl("listaCurso");
		} else {
			msg.setUrl("inicio");
		}
		
		request.getSession().setAttribute("count" ,count);
		request.getSession().setAttribute("msg" ,msg);
		response.sendRedirect("resultPage2.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
