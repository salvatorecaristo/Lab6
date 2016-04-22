package it.polito.tdp.sudoku.model;

public class TestMain {
	
	final static int dim = 9;
	final static boolean debug = false;

	final static int levelEasy = 45;
	final static int levelAdvanced = 50;
	final static int levelExpert = 55;
	
	public static void main(String[] args) {

		System.out.println("Let's start!\n");
		
		// Per generare un nuova nuova griglia di Sudoku
		SudokuGenerator sg = new SudokuGenerator();
		int [][] matrix = sg.nextBoard(levelEasy);
		Utils.printMatrix(matrix, TestMain.dim);
		
		/* ALTERNATIVA N1 */
		System.out.println("Cerco tutte le soluzioni");
		RecursiveSudoku rs = new RecursiveSudoku();
		int c1 = rs.recursiveSudoku(matrix);
		System.out.println("Numero di soluzioni trovate: " + c1 );
		
		/* ALTERNATIVA N2 */
		System.out.println("\nCerco tutte le soluzioni (alternativa)");
		RecursiveSudoku2 rs2 = new RecursiveSudoku2();
		c1 = rs2.recursiveSudoku2(matrix);
		System.out.println("Numero di soluzioni trovate: " + c1 );
		
		/* ALTERNATIVA N3 */
		System.out.println("\nCerco una sola soluzione");
		RecursiveSudokuOne rsOne = new RecursiveSudokuOne();
		matrix = rsOne.recursiveSudokuOne(matrix);
		if (matrix == null) {
			System.out.println("Nessuna soluzione trovata");
		} else {
			System.out.println("Stampo soluzione trovata:");
			Utils.printMatrix(matrix, TestMain.dim);
		}
		
		return;
	}
}
