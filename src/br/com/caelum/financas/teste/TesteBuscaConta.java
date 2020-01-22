package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main (String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		/**
		 * Managed
		 */
		Conta conta = em.find(Conta.class, 1);
		Conta conta2 = em.find(Conta.class, 2);
		
		Conta conta3 = em.find(Conta.class, 3);
		System.out.println(conta);
		System.out.println(conta2);
		System.out.println(conta3);
		em.getTransaction().commit();
		em.close();
		/**
		 * Not-managed
		 */
	}
	
}
