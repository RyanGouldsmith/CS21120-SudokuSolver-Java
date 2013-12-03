/*
 * @(#) ReadFile.java 1.0 2013-10-18
 *
 * Copyright (c) 2013 Aberystwyth University.
 * All rights reserved.
 *
 */

package Sudoku.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Sudoku.RunProgram.Solver;
import SudokuSolver.model.Board;

/**
 * A class that reads in a sudoku board to the a data structure It reads in the
 * file to the 2D array and then assigns the value of the filereader to the
 * array element It then shows the array at the end.
 * 
 * @author Ryan Gouldsmith
 * @since 1.0 Initial development.
 * @see Board
 */

public class ReadFile {
	// //////////////// //
	// Class variables. //
	// //////////////// //
	private BufferedReader reader;
	private String line;
	private Board b = new Board();
	private int value;

	// ///////////// //
	// Constructors. //
	// ///////////// //

	/**
	 * This is the constructor for the class It creates a new Buffer reader for
	 * Entering the file
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 *             if file isn't found
	 */
	public ReadFile(String file) {
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.print("Enter a correct Filename");
		}
	}

	// ////////////// //
	// Class methods. //
	// ////////////// //
	/**
	 * The method with reads in the sudoku. This reads in the sudoku splitting
	 * each character and then adding the associative character to the int array
	 * It does this by parsing the values into ints.
	 * 
	 * @throws IOException
	 * @throws FileTooShortException
	 * @throws InvalidCharacterException
	 */
	public void read() throws IOException, FileTooShortException {
		try {
			for (int m = 0; m < 9; m++) {
				// reads in a line
				line = reader.readLine();

				for (int j = 0; j < 9; j++) {

					// if the reading in is equal to space then set it to 0
					if (line.length() != 9) {
						throw new FileTooShortException(
								"Error, not enough characters");

					}
					if (String.valueOf(line.charAt(j)).matches("[A-Za-z]")) {
						throw new InvalidCharacterException(
								"There's characters in the file please change the file");
					} else if (String.valueOf(line.charAt(j)).equals(" ")) {
						value = 0;
					} else {
						// parse the String as an int
						value = Integer
								.parseInt(String.valueOf(line.charAt(j)));
					}
					// set the square
					b.getSquare().setSquare(m, j, value);

					System.out.print(b.getSquare().getSquare(m, j));
				}

				System.out.print("\n");
			}
			reader.close();

			System.out.print("\n");

			Solver s = new Solver(b);

		} catch (NullPointerException e) {

		} catch (InvalidCharacterException e) {

		}
	}
}
