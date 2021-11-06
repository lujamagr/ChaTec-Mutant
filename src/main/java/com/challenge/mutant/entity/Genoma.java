package com.challenge.mutant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENOMA")
public class Genoma {
	
	@Id
	@Column(name="ADN", unique = true)
	private String adn;
	@Column(name="RESULT", nullable = false, length = 10)
	private String result;
	
	public Genoma() {
	}
	
	public Genoma(String adn, String result) {
		this.adn = adn;
		this.result = result;
	}
	
	
	public String getAdn() {
		return adn;
	}
	public void setAdn(String adn) {
		this.adn = adn;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
