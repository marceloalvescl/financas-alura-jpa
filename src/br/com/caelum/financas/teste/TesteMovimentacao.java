package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.enums.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacao {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		/*
		Conta conta = em.find(Conta.class, 2);
		
		Movimentacao mov = new Movimentacao();
		mov.setConta(conta);
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Socio Torcedor Botafogo");
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal(19.90));
		
		em.persist(mov);
		
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setConta(conta1);
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Mensalidade Fevereiro Faculdade Sinclair");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setValor(new BigDecimal(1856.23));
		
		em.persist(mov1);
		*/

		Conta conta1 = em.find(Conta.class, 1);
		Movimentacao mov2 = new Movimentacao();
		mov2.setConta(conta1);
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Transferencia entre contas de Carol");
		mov2.setTipo(TipoMovimentacao.ENTRADA);
		mov2.setValor(new BigDecimal(150.00));
		em.persist(mov2);
		
		Conta conta2 = em.find(Conta.class, 3);
		
		Movimentacao mov3 = new Movimentacao();
		mov3.setConta(conta2);
		mov3.setData(Calendar.getInstance());
		mov3.setDescricao("Cinemark Bad Boys");
		mov3.setTipo(TipoMovimentacao.SAIDA);
		mov3.setValor(new BigDecimal(18.90));
		em.persist(mov3);
		
		Movimentacao mov4 = new Movimentacao();
		mov4.setConta(conta2);
		mov4.setData(Calendar.getInstance());
		mov4.setDescricao("Restaurante Asa Nordestina");
		mov4.setTipo(TipoMovimentacao.SAIDA);
		mov4.setValor(new BigDecimal(49.80));
		em.persist(mov4);

		
		em.getTransaction().commit();
		em.close();
		
	}
}