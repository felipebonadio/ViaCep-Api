package com.example.cep;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cep2 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int cep;
	private String localidade;
	
	protected Cep2(){}
	
	public Cep2(int cep, String localidade) {
		this.cep = cep;
		this.localidade = localidade;
	}
	
	 @Override
	  public String toString() {
	    return String.format(
	        "Cep2[id=%d, Cep='%s', Localidade='%s']",
	        id, cep, localidade);
	  }

	public Long getId() {
		return id;
	}

	public int getCep() {
		return cep;
	}

	public String getLocalidade() {
		return localidade;
	}	
	
}
