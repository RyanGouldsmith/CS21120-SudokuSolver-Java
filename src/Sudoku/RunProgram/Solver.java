/*
 * @(#) Solver.java 1.1 2013-10-18
 *
 * Copyright (c) 2013 Aberystwyth University.
 * All rights reserved.
 *
 */
package Sudoku.RunProgram;

import SudokuSolver.model.Board;

/**
 * Solve - A class that checks if the board is complete, and checking all the
 * available candidates.
 * <p>
 * Checks to see if the board is complete
 * 
 * @author (Ryan Gouldsmith ryg1@aber.ac.uk)
 * @since 1.0
 * @version 1.0 (put status of version here)
 * @see ReadFile()
 * @see Board()
 * 
 */
public class Solver {
	// //////////////// //
	// Class variables. //
	// //////////////// //
	/**
	 * Sets up the instansiation of Board
	 */
	private Board b;

	/**
	 * The constructor checks to see if the board isn't complete. Whilst it
	 * isn't complete check for available candidates Finally when the board is
	 * complete, print the board to the terminal
	 * 
	 * @param b2
	 *            is the board parameter to shallowcopy the reference of board
	 *            in this class.
	 */
	public Solver(Board b2) {
		this.b = b2;

		while (!(b.isComplete())) {
			for (int z = 0; z < 9; z++) {
				for (int t = 0; t < 9; t++) {
					// checks for available candidatess
					b.availableCandidates(z, t, b);

				}
			}

		}

		for (int g = 0; g < 9; g++) {
			for (int r = 0; r < 9; r++) {
				// gets the board again
				System.out.print(b.getSquare().getSquare(g, r));
			}
			System.out.print("\n");
		}
	}
}
