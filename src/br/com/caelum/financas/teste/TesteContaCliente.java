package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		conta.setId(1);
		
		Cliente cliente = new Cliente();
		cliente.setConta(conta);
		cliente.setEndereco("Charles de Gaulle");
		cliente.setNome("Jhonathan da Silva");
		cliente.setProfissao("Programador Java Jr");
		
		EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();
        
        
        em.persist(cliente);
        
        em.getTransaction().commit();

        em.close();
		 
	}
	
}
