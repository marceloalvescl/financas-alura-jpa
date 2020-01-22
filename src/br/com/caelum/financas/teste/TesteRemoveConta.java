package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoveConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		try {
			em.remove(conta);
			em.getTransaction().commit();
		}catch (IllegalArgumentException e){
			System.out.println("Conta de id 1 já foi removida!");
		}finally {
			em.close();
		}
	}
}
