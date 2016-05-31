package it.polito.tdp.sudoku.model;

public class Level {

	int livello ;
	String nomeLivello;
	
	public Level(int livello, String nomeLivello) {
		this.livello = livello;
		this.nomeLivello = nomeLivello;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public String getNomeLivello() {
		return nomeLivello;
	}

	public void setNomeLivello(String nomeLivello) {
		this.nomeLivello = nomeLivello;
	}

	@Override
	public String toString() {
		return nomeLivello ;
	}
	
}
