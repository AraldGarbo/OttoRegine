package it.polito.tdp.regine;

import java.util.*;



public class Regine {

	public List<Integer> posiziona(int N){
		
		List<Integer> soluzione = new ArrayList<>();
		if(cerca(soluzione, N, 0)) return soluzione;
		else return null;
	}
	
	public boolean cerca(List<Integer> scacchiera, int N, int livello) {
		
		if (livello == N) {
			return true; //caso terminale, soluzione trovata
		}
		
		for (int mossa = 0; mossa < N; mossa++ ) {
			if(posizioneSicura(scacchiera, livello, N, mossa)) {
				scacchiera.add(mossa);
				if(cerca(scacchiera, N, livello+1)) return true;
				scacchiera.remove(livello);
			}
		}
		return false;
	}

	private boolean posizioneSicura(List<Integer> scacchiera, int livello, int n, int mossa) {
		
		//colonne
		for(int riga = 0; riga < livello; riga++) {
			if(scacchiera.get(riga)==mossa) return false;
		//diagonale dx
		if(riga - scacchiera.get(riga) == livello - mossa) return false;
		
		//diagonale sx
		if(riga + scacchiera.get(riga) == livello + mossa) return false;
		}
		return true;
	}
	
	}

	