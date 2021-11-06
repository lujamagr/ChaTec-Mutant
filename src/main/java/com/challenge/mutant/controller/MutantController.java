package com.challenge.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.mutant.dto.DnaDTO;
import com.challenge.mutant.dto.StatsDTO;
import com.challenge.mutant.entity.Genoma;
import com.challenge.mutant.service.MutantService;
import com.challenge.mutant.utils.MutantUtil;

@RestController
public class MutantController {

	@Autowired
	MutantService mutantservice;
	
	
	/*
	 * Consulta las estadisticas de los genomas
	 */
	@GetMapping(value = "/stats")
	public ResponseEntity<StatsDTO> stats(){
	
		Long mutantes = mutantservice.mutants();
		Long humanos = mutantservice.humans();
		Double ratio =   mutantes.doubleValue()/humanos.doubleValue();
		
		StatsDTO statsdto = new StatsDTO(mutantes, humanos, ratio);
		return new ResponseEntity<StatsDTO>(statsdto, HttpStatus.OK);
	}
	
	/*
	 * Valida analiza el adn
	 */
	@PostMapping(value="mutant")
	public ResponseEntity<?> esMutante(@RequestBody DnaDTO dnadto) {
	
		if (MutantUtil.valiateadn(dnadto)) {
			String cadenamutante = "";
			for (int i = 0; i <= dnadto.getDna().length - 1; i++) {
				cadenamutante = cadenamutante+dnadto.getDna()[i];
			}
			
			if (MutantUtil.isMutant(dnadto.getDna())) {
				// "Este es un mutante"
				Genoma genoma = new Genoma();
				genoma.setAdn(cadenamutante);
				genoma.setResult("Mutant");
				
				mutantservice.save(genoma);
				
				return new ResponseEntity<>(null, HttpStatus.OK);
			}

			else {
				// "Este es Humano"
				Genoma genoma = new Genoma();
				genoma.setAdn(cadenamutante);
				genoma.setResult("Human");
				
				mutantservice.save(genoma);
				return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			}

		} else {
			// "Cadena no valida"
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
}
