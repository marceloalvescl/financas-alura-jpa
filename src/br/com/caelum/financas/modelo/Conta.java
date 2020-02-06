package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Created by leonardocordeiro on 24/02/17.
 */

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JoinColumn(unique = true)
	@OneToOne
	private Cliente cliente;

	private String banco;
	private String agencia;
	private String numero;

	@OneToMany(mappedBy = "conta")
	private List<Movimentacao> movimentacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void addMovimentacao(Movimentacao movimentacao) {
		this.movimentacoes.add(movimentacao);
	}

	@Override
	public String toString() {
		return " id=" + id + ",\n titular=" + cliente + ",\n banco=" + banco + ",\n agencia=" 
				+ agencia + ",\n numero="
				+ numero;
	}

}
