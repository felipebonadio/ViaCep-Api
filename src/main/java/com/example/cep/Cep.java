package com.example.cep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cep")
public class Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	@Column(nullable = false)
	private String cep;
	@Column(nullable = false)
	private String localidade;	
	@Column(nullable = false)
	private String logradouro;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String uf;
	
	public Cep() {
	}

	
	public Cep(  String localidade, String cep, String logradouro, String bairro, String uf) {
		super();
		this.cep = cep;
		this.localidade = localidade;		
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.uf = uf;
	}
	
	public Integer getId() {
		return id;
	}


	public String getCep() {
		return cep;
	}


	public String getLocalidade() {
		return localidade;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public String getBairro() {
		return bairro;
	}


	public String getUf() {
		return uf;
	}


	


	@Override
	public String toString() {
		return "Cep [id=" + id + ", cidade=" + localidade + ", cep=" + cep + ", rua=" + logradouro + ", bairro=" + bairro + ", uf="
				+ uf + "]";
	}	

}