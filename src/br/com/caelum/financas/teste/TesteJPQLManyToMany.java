package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQLManyToMany {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String queryString = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		Query query = em.createQuery(queryString);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultado = query.getResultList(); 
		
		for (Movimentacao movimentacao : resultado) {
			System.out.println(movimentacao.getConta().getId());
			System.out.println(movimentacao.getDescricao());
		}
		
		em.getTransaction().commit();
		em.close();
		
		
	}
	
}
