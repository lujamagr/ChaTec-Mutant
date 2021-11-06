package com.challenge.mutant.dto;


/*
 * Capta la cadena adn de ingreso
 */
public class DnaDTO {
	private String[] dna;
	

	public DnaDTO(String[] dna) {
		this.dna = dna;
	}
	
	public DnaDTO() {
		
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	
	
}
