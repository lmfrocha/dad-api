package br.com.pucminas.dad.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "DOACOES")
public class Doacoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "VALOR")
	private Double valor;

	@Column(name = "DATA")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "CPF")
	private Long cpf_doador;
	
	
	public Doacoes() {}

	public Doacoes(Double valor, Date data, Long cpf_doador) {
		this.valor = valor;
		this.data = data;
		this.cpf_doador = cpf_doador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getCpf_doador() {
		return cpf_doador;
	}

	public void setCpf_doador(Long cpf_doador) {
		this.cpf_doador = cpf_doador;
	}
	
	
	
	
	
}
