package it.polito.tdp.sudoku.model;

public class RecursiveSudoku2 {

	/*
	 * ALTERNATIVA N2 -- TROVO TUTTE LE SOLUZIONI COME FUNZIONE DI CONTROLLO
	 * UTILIZZO QUELLA FORNITA DALLA CLASSE SudokuGenerator
	 */

	static int solutionsCounter = 0;
	SudokuGenerator sg;

	public int recursiveSudoku2(int[][] matrix) {

		sg = new SudokuGenerator();
		recursiveSudokuSolver2(matrix, 0);
		return solutionsCounter;
	}

	/*
	 * FUNZIONE RICORSIVA: Il parametro level identifica il livello nell'albero
	 * della ricorsione. Nel caso del Sudoku, identifica la posizione della
	 * matrice in cui vado a posizionare un nuovo numero.
	 */
	private void recursiveSudokuSolver2(int[][] matrix, int level) {

		// Condizione di terminazione
		if (level == Utils.dim * Utils.dim) {

			// Ho trovato una nuova soluzione!
			solutionsCounter++;

			if (TestMain.debug) {
				// incremento il contatore e stampo la matrice.
				System.out.println("Yeah!");
				Utils.printMatrix(matrix, Utils.dim);
			}

			return;
		}

		// Calcolo la riga e la colonna della matrice in base al livello
		int riga = level / Utils.dim;
		int colonna = level % Utils.dim;

		// Posiziono un numero solo se la casella è vuota (contiene uno 0)
		if (matrix[riga][colonna] == 0) {

			// Per ciascuna colonna
			for (int i = 1; i <= Utils.dim; i++) {
				
				// Controlla se inserire l'i-esimo numero è corretto.
				if (sg.legalMove(matrix, riga, colonna, i)) {

					// Aggiungi una nuova regina sulla riga corrente
					matrix[riga][colonna] = i;

					// Chiama la funzione ricorsiva
					recursiveSudokuSolver2(matrix, level + 1);

					// Backtracking: rimuovo la regina appena aggiunta
					matrix[riga][colonna] = 0;
				}
			}

		} else {

			// Altrimenti richiamo semplicemente la funzione
			// ricorsiva sul livello successivo
			recursiveSudokuSolver2(matrix, level + 1);
		}
	}
}