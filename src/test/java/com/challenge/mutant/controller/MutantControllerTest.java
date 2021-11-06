package com.challenge.mutant.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.challenge.mutant.dto.DnaDTO;
import com.challenge.mutant.dto.StatsDTO;
import com.challenge.mutant.entity.Genoma;
import com.challenge.mutant.service.MutantService;


@ExtendWith(MockitoExtension.class)
class MutantControllerTest {

	@InjectMocks
	MutantController mutantControl;

	@Mock
	MutantService mutantservice;
	
	
	@Test
	public void testEsMutante() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Genoma genoma = new Genoma();
        genoma.setAdn("ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG");
        genoma.setResult("Mutant");
        when(mutantservice.save(any(Genoma.class))).thenReturn(genoma);
         
        DnaDTO dnadto = new DnaDTO();
 	   dnadto.setDna(new String[] {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        
        ResponseEntity<?> responseEntity = mutantControl.esMutante(dnadto);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		
	}
	
	
	@Test
	public void testEsHumano() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Genoma genoma = new Genoma();
        genoma.setAdn("ATGCGACAGTGCTTATGTAGACAGCCCTTATCACTG");
        genoma.setResult("Human");
        when(mutantservice.save(any(Genoma.class))).thenReturn(genoma);
         
        DnaDTO dnadto = new DnaDTO();
 	   dnadto.setDna(new String[] {"ATGCGA","CAGTGC","TTATGT","AGACAG","CCCTTA","TCACTG"});
        
        ResponseEntity<?> responseEntity = mutantControl.esMutante(dnadto);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(403);
		
	}
	
	@Test
	void testStats() {
		
		StatsDTO stats1 = new StatsDTO(1L,1L,1d);
		
        when(mutantservice.mutants()).thenReturn(stats1.getCount_mutant_dna());
        when(mutantservice.humans()).thenReturn(stats1.getCount_human_dna());
 
        ResponseEntity<StatsDTO> responseEntity = mutantControl.stats();
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

}
