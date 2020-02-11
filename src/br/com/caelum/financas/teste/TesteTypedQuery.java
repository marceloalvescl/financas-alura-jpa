package br.com.caelum.financas.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTypedQuery{

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		TypedQuery<Double> query1 = em.createQuery("select avg(m.valor) from Movimentacao m where conta_id = :conta" +
				  " group by day(m.data), month(m.data), year(m.data)", Double.class);
		query1.setParameter("conta", conta);
		List<Double> valores = query1.getResultList();
		
		for (Double valor : valores) {
			System.out.println(valor);
		}
		
		String jpql = "select m.data, avg(m.valor) from Movimentacao m where conta_id = :conta" +
					  " group by day(m.data), month(m.data), year(m.data)";
		
		Query query = em.createQuery(jpql);
		query.setParameter("conta", conta);
		
		List<Object[]> resultado = query.getResultList();
		for (Object[] object : resultado) {
			Calendar date = (Calendar) object[0];
			System.out.println("Dia: " + new SimpleDateFormat("dd-MM-yyyy").format(date.getTime()) +
								" Média: "+ object[1]);
		}
		
				
	}
}
