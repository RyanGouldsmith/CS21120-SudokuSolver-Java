/*
 * @(#) NewPossibleValues.java 1.1 2013-10-18
 *
 * Copyright (c) 2013 Aberystwyth University.
 * All rights reserved.
 *
 */
package SudokuSolver.model;

import java.util.LinkedList;
import java.util.List;

/**
 * New Possible Values - Creates a list of the Possible Values for each square
 * and uses algorithms to sort sudoku values.
 * <p>
 * Gets a list of values for each cell 1-9 It then removes any values from the
 * list that are in the Grid *
 * 
 * @author (Ryan Gouldsmith ryg1@aber.ac.uk)
 * @since 1.0
 * @version 1.0
 * @Square()
 * @Board()
 */
public class PossibleValues {
	// //////////////// //
	// Class variables. //
	// //////////////// //
	private int values[][];
	private List<Integer> listOfNumbers = new LinkedList<Integer>();
	private Board board;
	// a Linked list of all the possible values that can be in a row
	private LinkedList<Integer> possibleRowValues = new LinkedList<Integer>();
	// a linked list of all the possible values in a column
	private LinkedList<Integer> possibleColumnValues = new LinkedList<Integer>();
	// a Linked list of all the possible values in a box
	private LinkedList<Integer> possibleBoxValues = new LinkedList<Integer>();
	private LinkedList<Integer> ab = new LinkedList<Integer>();
	private final int DEFAULT = 9;

	/**
	 * This constructor passed in the Squares array and the board in memory
	 * 
	 * @param oldArray
	 *            is the Square array in which the numbers are set
	 * @param b
	 *            is the board in which we#re currently using
	 */
	public PossibleValues(int[][] oldArray, Board b) {
		values = oldArray;
		board = b;
	}

	/**
	 * This is the Naked Singles Algorithm which works out individual candidates
	 * for the cell If there is only one element then it will add it to the
	 * array
	 * 
	 * @param a
	 *            is the index to row array
	 * @param b
	 *            is the index to the col array
	 */
	public void nakedSingles(int a, int b) {
		// calls the totalValues method which works out the numbers for each
		// square
		totalValues(a, b);
		for (int s = 0; s < DEFAULT; s++) {
			// loops over the total values and if the number is in the total
			// values, for that square then it will add it to the List Of
			// Numbers
			if (totalValues(a, b).contains(s + 1)) {
				listOfNumbers.add(s + 1);
			}
		}
		// checks to see if it's length is 1. If it is then it means that
		// there's only one candidate
		if (listOfNumbers.size() == 1) {
			// it then sets it to be the element at position 0.
			board.getSquare().setSquare(a, b, listOfNumbers.get(0));
		}
	}

	/**
	 * This method is for the hiddenSingles Algorithm in which it will check to
	 * see if out of the list of candidates then only one is in the row column
	 * or Box.
	 * 
	 * @param a
	 *            is the row index
	 * @param b
	 *            is the column index
	 */
	public void hiddenSingles(int a, int b) {
		// calls the totalValue method
		totalValues(a, b);
		// stores all the values in a temporary LinkedList
		for (int v = 0; v < DEFAULT; v++) {
			if (totalValues(a, b).contains(v + 1)) {

				if (ab.contains(v + 1)) {
					ab.remove(ab.indexOf(v + 1));
				} else {
					ab.add(v + 1);
				}
			}

		}
		if (ab.size() == 1) {
			// System.out.print(" Value for "+ a + " " + b + " is " + ab.get(0)+
			// "\n");
			board.getSquare().setSquare(a, b, ab.get(0));
			nakedSingles(a, b);

		}
	}

	/**
	 * This method populates the LinkedList with all the possible values ranging
	 * from 1-9
	 * 
	 * @param e
	 *            is that it takes a generic list and adds all the values to it
	 */
	private void populateList(List<Integer> e) {
		for (int i = 1; i < 10; i++) {
			e.add(i);
		}
	}

	/**
	 * This returns all the possible values in the row as a LinkedList.
	 * 
	 * @param a
	 *            is the row index
	 * @return the LinkedList of all the possible row values
	 */
	private LinkedList<Integer> getPossibleRowValues(int a) {
		// populates the list
		populateList(possibleRowValues);
		for (int i = 0; i < DEFAULT; i++) {
			// checks to see if the number is in the box
			if (board.isNumberInBox(a, i)) {
				// if it is remove the value of it from the LinkedList
				possibleRowValues.remove(possibleRowValues
						.indexOf(getValuesArray()[a][i]));
			}
		}
		return possibleRowValues;
	}

	/**
	 * This method works out the possible column Values and then returns all the
	 * values
	 * 
	 * @param a
	 *            is the column index
	 * @return returns the column values LinkedList
	 */
	private LinkedList<Integer> getPossibleColValues(int a) {
		// populate it with 1-9
		populateList(possibleColumnValues);
		for (int i = 0; i < DEFAULT; i++) {
			// checks to see if the number is in the column
			if (board.isNumberInColumn(i, a)) {
				// removes it at the index if true
				possibleColumnValues.remove(possibleColumnValues
						.indexOf(getValuesArray()[i][a]));
			}
		}
		return possibleColumnValues;
	}

	/**
	 * Gets the possible Box values that are remaining in the box
	 * 
	 * @param a
	 *            is the row index
	 * @param b
	 *            is the column index
	 * @return the LinkedList of all the possibleValues
	 */
	private LinkedList<Integer> getPossibleBoxValues(int a, int b) {
		// populates
		populateList(possibleBoxValues);
		// works so we only use the boxes
		int boxa = a / 3 * 3;
		int boxb = b / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// checks if the number is in the box
				if (board.isNumberInBox(boxa + i, boxb + j)) {
					// removes the value up to 3 in the box
					possibleBoxValues.remove(possibleBoxValues
							.indexOf(getValuesArray()[boxa + i][boxb + j]));
				}
			}
		}
		return possibleBoxValues;
	}

	/**
	 * This populates all the row column and box linked list to one list which
	 * will have the possible values for that Cell
	 * 
	 * @param a
	 *            takes the row index
	 * @param b
	 *            takes the column index
	 * @return the total
	 */
	private LinkedList<Integer> totalValues(int a, int b) {
		// store a local variable of all the possible values
		LinkedList<Integer> totalPossibleValues = new LinkedList<Integer>();
		for (int h = 0; h < DEFAULT; h++) {
			// checks to see if the cells contains the number. Has to be + 1
			// because it starts at 0
			if (getPossibleBoxValues(a, b).contains(h + 1)
					&& getPossibleRowValues(a).contains(h + 1)
					&& getPossibleColValues(b).contains(h + 1))
				totalPossibleValues.add(h + 1);
		}
		return totalPossibleValues;
	}

	/**
	 * Gets the shallow copy of the Squares board
	 * 
	 * @return the values array as a 2d ints
	 */
	private int[][] getValuesArray() {
		return values;

	}

}
