package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.enums.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Investimentos");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Venda de ativo na bolsa de valores");
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal(6650.0));
		movimentacao.setCategorias(Arrays.asList(categoria1));
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
