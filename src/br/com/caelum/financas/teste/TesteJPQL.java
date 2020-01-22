package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.enums.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		em.getTransaction().begin();
		String queryString = "select m from Movimentacao m where m.tipo = :pTipo";
		
		Query query = em.createQuery(queryString);	
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		List<Movimentacao> resultado = query.getResultList();
	
		for (Movimentacao mov : resultado) {
			System.out.println("Id da conta: " + mov.getConta().getId());
			System.out.println("Descrição: " + mov.getDescricao());
		}
		em.getTransaction().commit();
		em.close();
	}
}
