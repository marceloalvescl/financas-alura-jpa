package br.com.caelum.financas.teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

/**
 * Created by leonardocordeiro on 24/02/17.
 * Learned by marceloalvescalo on 19/01/20, 20/01/20.
 */
public class TesteConta {

    public static void main(String[] args) {
    	
    	ArrayList<Conta> listaContas = new ArrayList<Conta>();
    	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    	
        Conta leoConta = new Conta();
        leoConta.setBanco("Caixa Economica");
        leoConta.setAgencia("123");
        leoConta.setNumero("456");
    	Cliente leonardo = new Cliente();
    	leonardo.setConta(leoConta);
        leonardo.setEndereco("Rua duvivier 32");
        leonardo.setNome("Leonardo");
        leonardo.setProfissao("Professor");
    	leoConta.setCliente(leonardo);
        listaContas.add(leoConta);
        listaClientes.add(leonardo);
        
        Conta marceloConta = new Conta();
        marceloConta.setBanco("Santander");
        marceloConta.setAgencia("2269");
        marceloConta.setNumero("01039967-2");
        Cliente marcelo = new Cliente();
        marcelo.setConta(marceloConta);
        marcelo.setEndereco("SHIN QI 12 CONJ 6 CASA 5");
        marcelo.setNome("Marcelo");
        marcelo.setProfissao("Estagiário");
        marceloConta.setCliente(marcelo);
        listaContas.add(marceloConta);
        listaClientes.add(marcelo);
        
        Conta testeConta = new Conta();
        testeConta.setBanco("Banco do Brasil");
        testeConta.setAgencia("3321");
        testeConta.setNumero("45123");
        Cliente teste = new Cliente();
        teste.setEndereco("teste");
        teste.setNome("teste");
        teste.setProfissao("Testador");
        teste.setConta(testeConta);
        testeConta.setCliente(teste);
        listaContas.add(testeConta);
        listaClientes.add(teste);

        Conta padraoConta = new Conta();
        padraoConta.setBanco("Banco do Brasil");
        padraoConta.setAgencia("3321");
        padraoConta.setNumero("45123");
        Cliente padrao = new Cliente();
        padrao.setEndereco("padrao");
        padrao.setNome("padrao");
        padrao.setProfissao("padrao");
        padrao.setConta(padraoConta);
        padraoConta.setCliente(padrao);
        listaContas.add(padraoConta);
        listaClientes.add(padrao);
        
        EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();

        for (Cliente cliente : listaClientes) {
        	em.persist(cliente);
        }
        
        for (Conta conta : listaContas) {
			em.persist(conta);
		}
        
        em.getTransaction().commit();

        em.close();
    }
}
