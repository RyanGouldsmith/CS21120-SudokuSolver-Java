/*
 * @(#) Board.java 1.1 2013-10-18
 *
 * Copyright (c) 2013 Aberystwyth University.
 * All rights reserved.
 *
 */
package SudokuSolver.model;

/**
 * Board - Creates the board.
 * <p>
 * Creates the board using a 2D array of Squares. This then board sets board
 * values, gets board values, checks if the number is in the box, column and
 * row. This also checks to see if the puzzle will be solved.
 * 
 * @author (Ryan Gouldsmith ryg1@aber.ac.uk)
 * @since 1.0
 * @version 1.0
 * @Square()
 * @NewPossibleValues()
 */
public class Board {
	// //////////////// //
	// Class variables. //
	// //////////////// //
	private Board bd;
	private Square[][] board;
	private int DEFAULT_SIZE = 9;
	private Square square = new Square();
	private PossibleValues values;

	/**
	 * Creates a new Board, each value beein a new square of DefaultSize 9
	 */
	public Board() {
		board = new Square[DEFAULT_SIZE][DEFAULT_SIZE];

	}

	// set a position on the board
	/**
	 * This sets a position on the board to be a square
	 * 
	 * @param a
	 *            is the row value for the array
	 * @param b
	 *            is the column value for the array
	 * @param x
	 *            is the square
	 */
	public void setBoard(int a, int b, Square x) {
		board[a][b] = x;
	}

	/**
	 * This method returns the Square from the board indexes
	 * 
	 * @param a
	 *            is the row index
	 * @param b
	 *            is the column index
	 * @return the Square associated with the board
	 */
	public Square getBoard(int a, int b) {
		return board[a][b];
	}

	// checks to see if the number is in the box
	/**
	 * This methods checks to see if the box is free, inside the 3x3 grid.
	 * 
	 * @param b
	 *            is the row index
	 * @param a
	 *            is the column index
	 * @return true or false whether it is in empty or not
	 */
	public boolean isNumberInBox(int b, int a) {
		if (getSquare().getSquare(b, a) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if there box in the row is empty or not
	 * 
	 * @param a
	 *            takes the row index
	 * @param b
	 *            takes the column index
	 * @return whether it is empty in the row or not
	 */
	public boolean isNumberInRow(int a, int b) {
		if (getSquare().getSquare(a, b) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if there's a number in the column or not
	 * 
	 * @param a
	 *            takes the row index
	 * @param b
	 *            takes the column index
	 * @return whether the box is empty or not
	 */
	// checks to see if the numberis sin the column
	public boolean isNumberInColumn(int a, int b) {
		if (getSquare().getSquare(a, b) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check the available Candidates. This is also where
	 * the algorithms run from.
	 * 
	 * @param a
	 *            takes the row index
	 * @param b
	 *            takes the col index
	 * @param b2
	 *            takes a board, from the file reader
	 */
	// method for checking the possiblitly of available candidates/
	public void availableCandidates(int a, int b, Board b2) {
		this.bd = b2;
		// creates a new Instance of PossibleValues
		values = new PossibleValues(bd.getSquare().getSquare(), bd);
		// checks to see if the indexes are an empty square
		if (bd.getSquare().getSquare(a, b) == 0) {
			// calls the naked single method
			values.nakedSingles(a, b);
			// calls the Hidden singles method
			values.hiddenSingles(a, b);
		} else {
			// System.out.println("There are no candidates");
		}
	}

	/**
	 * This method gets the board length
	 * 
	 * @return an int of the length of the board
	 */
	public int getLength() {
		return board.length;
	}

	/**
	 * This method gets the instance of the Square
	 * 
	 * @return the instance of Square
	 */
	public Square getSquare() {
		return square;
	}

	/**
	 * This method checks whether the sudoku board is complete or not. It loops
	 * through the board, and if it comes across a square which is not filled
	 * then returns false
	 * 
	 * @return true/false to whether the board is complete.
	 */
	public boolean isComplete() {
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				if (getSquare().getSquare(i, j) == 0) {
					return false;
				}
			}
		}
		return true;
	}
}