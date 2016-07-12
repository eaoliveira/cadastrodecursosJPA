package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Curso;
import model.Endereco;
import model.Pedido;

public class CursoDao {
	//private List<Pedido> lista = new ArrayList<>();
	private List<Curso> listaEnd = new ArrayList<>();
	private static CursoDao referencia = null;
	private int id = 0;
	private int idEnd = 0;

	private CursoDao() {
	}

	public static CursoDao getInstance() {
		if (referencia == null)
			referencia = new CursoDao();

		return referencia;
	}

/*public void adiciona(Curso obj) {
		obj.setId(id++);
		lista.add(obj);
	}*/

	public void adiciona(Curso obj) {
		obj.setId(idEnd++);
		listaEnd.add(obj);
	}
		
	/*public List<Pedido> getPedidos() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}*/
		
	public List<Curso> getCurso() {
		return Collections.synchronizedList(new ArrayList<>(listaEnd));
	}
	
	public Curso getCurso(Integer id) {
		Curso end = null;
		for (Curso obj : listaEnd) {
			if(obj.getId().equals(id)) {
				end = obj;
				break;
			}
		}
		
		return end;
	}
	
	public boolean delCurso(int id) {
		return listaEnd.removeIf(end -> end.getId() == id);
	}
	
	public int contadorCurso() {
		return listaEnd.size();
	}
}
