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
		
		Conta conta = em.find(Conta.class, 2);
		
		Movimentacao mov = new Movimentacao();
		mov.setConta(conta);
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Socio Torcedor Botafogo");
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal(19.90));
		
		em.getTransaction().begin();
		
		em.persist(mov);
		
		em.getTransaction().commit();
		em.close();
		
	}
}