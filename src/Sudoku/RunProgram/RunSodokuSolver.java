/*
 * @(#) RunSodokuSolver.java 1.1 2013-10-18
 *
 * Copyright (c) 2013 Aberystwyth University.
 * All rights reserved.
 *
 */
package Sudoku.RunProgram;

import java.io.IOException;
import java.util.Scanner;

import Sudoku.Input.FileTooShortException;
import Sudoku.Input.InvalidCharacterException;
import Sudoku.Input.ReadFile;

/**
 * RunSodokuSolver - A class that runs the system.
 * <p>
 * This class runs the system.
 * 
 * @author (Ryan Gouldsmith ryg1@aber.ac.uk)
 * @since 1.0
 * @version 1.0 (put status of version here)
 * @see ReadFile()
 * @see Board()
 * 
 */

public class RunSodokuSolver {

	/**
	 * This Is where the program will run from
	 * 
	 * @param args
	 *            is for arguments from the command line
	 * @throws IOException
	 * @throws FileTooShortException
	 * @throws InvalidCharacterException
	 */
	public static void main(String[] args) throws IOException,
			FileTooShortException, InvalidCharacterException {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the file with .SUD as the file extension");
		String file = s.next();
		ReadFile reader = new ReadFile(file);
		reader.read();
		s.close();

	}

}
