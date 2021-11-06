package com.challenge.mutant.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.challenge.mutant.dto.DnaDTO;

public class MutantUtil {
	
	/*
	 * Evalua adn?
	 */
	public static boolean isMutant(String[] dna) {

		char[][] cadenadna = new char[dna.length][dna[0].length()];
		int coincide = 0;

		for (int i = 0; i < dna.length - 1; i++) {
			cadenadna[i] = dna[i].toCharArray();
		}

		int tamx = cadenadna.length - 1;
		int tamy = cadenadna[0].length - 1;
		int x = 0;
		int y = 0;

		for (int i = 0; i < cadenadna.length - 1; i++) {
			for (int j = 0; j < cadenadna[i].length - 1; j++) {
				if (coincide > 1) {
					return true;
				} else {
					if (j < tamy && cadenadna[i][j] == cadenadna[i][j + 1]) {
						y = j + 1;

						if (y < tamy && cadenadna[i][y] == cadenadna[i][y + 1]) {

							y = y + 1;

							if (y < tamy && cadenadna[i][y] == cadenadna[i][y + 1]) {
								coincide = coincide + 1;
							}
						}
					}
					else if (i < tamx && cadenadna[i][j] == cadenadna[i + 1][j]) {
						x = i + 1;

						if (x < tamx && cadenadna[x][j] == cadenadna[x + 1][j]) {
							x = x + 1;

							if (x < tamx && cadenadna[x][j] == cadenadna[x + 1][j]) {
								coincide = coincide + 1;
							}
						}
					}
					else if (i < tamx && j < tamy && cadenadna[i][j] == cadenadna[i + 1][j + 1]) {
						x = i + 1;
						y = j + 1;

						if (x < tamx && y < tamy && cadenadna[x][y] == cadenadna[x + 1][y + 1]) {
							x = x + 1;
							y = y + 1;

							if (x < tamx && y < tamy && cadenadna[x][y] == cadenadna[x + 1][y + 1]) {
								coincide = coincide + 1;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Validación de adn
	 */
	public static boolean valiateadn(DnaDTO dnadto) {
		Pattern pat = Pattern.compile("(A|T|C|G)+");

		for (int i = 0; i <= dnadto.getDna().length - 1; i++) {
			Matcher mat = pat.matcher(dnadto.getDna()[i]);
			if (!mat.matches()) 
				return false;
		}
	return true;
	}
}
