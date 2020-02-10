package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.enums.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		em.getTransaction().begin();
		String queryString = "select sum(m.valor) from Movimentacao m where m.tipo = :pTipo";
		Query query = em.createQuery(queryString);	
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		BigDecimal soma = (BigDecimal) query.getSingleResult();
		
		System.out.println("A soma é: " + soma);
		
		em.getTransaction().commit();
		em.close();
	}
}
