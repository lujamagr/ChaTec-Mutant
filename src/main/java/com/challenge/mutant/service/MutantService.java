package com.challenge.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.mutant.entity.Genoma;
import com.challenge.mutant.repository.MutantRepository;

@Service
public class MutantService {

	@Autowired
	MutantRepository mutantrepo;

	/*
	 * Guarda genomas consultados
	 */
	@Transactional
	public Genoma save(Genoma genoma) {
		return genoma = mutantrepo.save(genoma);
	}
	
	/*
	 * Consulta numero de mutantes en BD
	 */
	public Long mutants() {
		return mutantrepo.mutants();
	}
	
	/*
	 * Consulta numero de humanos en BD
	 */
	public Long humans() {
		return mutantrepo.humans();
	}
}