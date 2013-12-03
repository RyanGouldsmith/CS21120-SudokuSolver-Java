/*
 * @(#) Square.java 1.1 2013-10-18
 *
 * Copyright (c) 2013 Aberystwyth University.
 * All rights reserved.
 *
 */
package SudokuSolver.model;

/**
 * This is the Square class which each number will have a given value.
 * 
 * @author (Ryan Gouldsmith ryg1@aber.ac.uk)
 * @since 1.0
 * @version 1.0
 */
public class Square {
	// //////////////// //
	// Class variables. //
	// //////////////// //
	private int square[][];
	private int DEFAULT_SIZE = 9;

	/**
	 * Sets each Square to have a 9x9 array
	 */
	public Square() {
		square = new int[DEFAULT_SIZE][DEFAULT_SIZE];
	}

	/**
	 * This gets the Square
	 * 
	 * @return the whole array of squares
	 */
	public int[][] getSquare() {
		return square;
	}

	/**
	 * This gets the squares value at 2 given indexes
	 * 
	 * @param a
	 *            is the row index
	 * @param b
	 *            is the col index
	 * @return the integer value for the given index
	 */
	public int getSquare(int a, int b) {
		return square[a][b];
	}

	/**
	 * This sets the square to be a certain value
	 * 
	 * @param a
	 *            is the row index
	 * @param b
	 *            is the column index
	 * @param c
	 *            is the value which you're setting
	 */
	public void setSquare(int a, int b, int c) {
		square[a][b] = c;
	}

}
