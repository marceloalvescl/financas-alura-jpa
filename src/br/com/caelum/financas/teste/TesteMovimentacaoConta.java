package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		
		Conta conta = em.find(Conta.class, 2);
		
		System.out.println(conta.getMovimentacoes());
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();
		System.exit(1);
	}

	
}
