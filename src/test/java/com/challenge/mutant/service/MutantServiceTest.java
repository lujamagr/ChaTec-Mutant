package com.challenge.mutant.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.mutant.entity.Genoma;
import com.challenge.mutant.repository.MutantRepository;

@SpringBootTest
class MutantServiceTest {

	@Autowired
	MutantService mutantServ;
	
	@Autowired
	MutantRepository mutantRepo;
	
	@Test
	void saveMutant() {
		Genoma gen = new Genoma();
		gen.setAdn("ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG");
		gen.setResult("Mutant");
		mutantServ.save(gen);
		Assertions.assertNotNull(mutantRepo.findById("ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG"));	
	}
	
	@Test
	void saveHuman() {
		Genoma gen = new Genoma();
		gen.setAdn("ATGCGACAGTGCTTATGTAGACAGCCCTTATCACTG");
		gen.setResult("Human");
		mutantServ.save(gen);
		Assertions.assertNotNull(mutantRepo.findById("ATGCGACAGTGCTTATGTAGACAGCCCTTATCACTG"));
	}

	@Test
	void countMutant() {
		Assertions.assertNotNull(mutantServ.mutants());
	}
	
	@Test
	void countHuman() {	
		Assertions.assertNotNull(mutantServ.humans());
	}
	
}
