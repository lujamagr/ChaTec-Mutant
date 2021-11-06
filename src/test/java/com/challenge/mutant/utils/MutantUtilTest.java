package com.challenge.mutant.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.challenge.mutant.dto.DnaDTO;


class MutantUtilTest {

	
	@Test
	void isMutant() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Assertions.assertTrue(MutantUtil.isMutant(dna));  ; 
		
	}
	
	@Test
	void isHuman() {
		String[] dna = {"ATGCGA","CAGTGC","TTGTGT","AGAATG","CCTCTA","TCACTG"};
		Assertions.assertFalse(MutantUtil.isMutant(dna));
		
	}
	
	@Test
	void valiateadnOK() {
		String[] dna = {"ATGCGA","CAGTGC","TTGTGT","AGAATG","CCTCTA","TCACTG"};
		DnaDTO dnadto = new DnaDTO(dna);
		
		Assertions.assertTrue(MutantUtil.valiateadn(dnadto));
		
	}
	
	@Test
	void valiateadnErr() {
		String[] dna = {"ATGCGA","CYGTGC","TTGTGT","AGAATG","CCTCTA","TCACTG"};
		DnaDTO dnadto = new DnaDTO(dna);
		
		Assertions.assertFalse(MutantUtil.valiateadn(dnadto));
		
	}
	
	
	
	

}
