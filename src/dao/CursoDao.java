package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Curso;
import model.Endereco;
import model.Pedido;

@Stateless
public class CursoDao {
	@PersistenceContext(name="CadastrodeCursosJPA")
    private EntityManager manager;
   	
	
	public void adiciona(Curso obj) {
		manager.merge(obj);
	}
			
	public boolean delCurso(int id) {
		Curso obj = manager.find(Curso.class, id);
		if (obj!=null){
			manager.remove(obj);
			return true;
			}
		else
		return false;
	}
	
	public List<Curso> getCurso(){
		return manager.createQuery("from Curso", Curso.class).getResultList();
		
	}
	public int contadorCurso() {
		return getCurso().size();
	}
}
