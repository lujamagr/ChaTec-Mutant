package com.challenge.mutant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.mutant.entity.Genoma;

@Repository
public interface MutantRepository extends JpaRepository<Genoma, String> {

	@Query(value = "select count(*) as count_mutant_dna from genoma where result = 'Mutant'", nativeQuery = true)
    public Long mutants();
	
	
	@Query(value="select count(*) as count_human_dna from genoma where result = 'Human'", nativeQuery = true)
	public Long humans();
	
}
