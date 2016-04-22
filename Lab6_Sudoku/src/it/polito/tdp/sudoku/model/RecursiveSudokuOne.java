package it.polito.tdp.sudoku.model;

public class RecursiveSudokuOne {

	/*
	 * ALTERNATIVA N3 -- TROVO UNA SOLA SOLUZIONE QUESTA É LA CLASSE CHE VA
	 * CHIAMATA DAL CONTROLLER
	 * 
	 */

	public int[][] recursiveSudokuOne(int[][] matrix) {
		return recursiveSudokuSolverOne(matrix, 0);
	}

	/*
	 * FUNZIONE RICORSIVA: Il parametro level identifica il livello nell'albero
	 * della ricorsione. Nel caso del Sudoku, identifica la posizione della
	 * matrice in cui vado a posizionare un nuovo numero.
	 */
	private int[][] recursiveSudokuSolverOne(int[][] matrix, int level) {

		// Condizione di terminazione
		if (level == Utils.dim * Utils.dim) {
			// Ho trovato una nuova soluzione!

			if (TestMain.debug) {
				// Stampo la matrice.
				System.out.println("Yeah!");
				Utils.printMatrix(matrix, Utils.dim);
			}

			return matrix;
		}

		// Calcolo la riga e la colonna della matrice in base al livello
		int riga = level / Utils.dim;
		int colonna = level % Utils.dim;

		// Posiziono un numero solo se la casella è vuota (contiene uno 0)
		if (matrix[riga][colonna] == 0) {

			// Per ciascuna colonna
			for (int i = 1; i <= Utils.dim; i++) {

				// Aggiungi una nuova regina sulla riga corrente
				matrix[riga][colonna] = i;

				// Controlla se il numero non è già presente
				if (Utils.check(matrix, true)) {
					// Chiama la funzione ricorsiva
					int[][] retMatrix = recursiveSudokuSolverOne(matrix, level + 1);
					if (retMatrix != null)
						return retMatrix;
				}

				// Backtracking: rimuovo la regina appena aggiunta
				matrix[riga][colonna] = 0;
			}

		} else {
			// Altrimenti richiamo semplicemente la funzione
			// ricorsiva sul livello successivo
			int[][] retMatrix = recursiveSudokuSolverOne(matrix, level + 1);
			if (retMatrix != null)
				return retMatrix;
		}

		return null;
	}
}
