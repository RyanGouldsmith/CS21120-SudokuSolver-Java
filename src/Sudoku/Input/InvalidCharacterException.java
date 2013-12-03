package Sudoku.Input;

public class InvalidCharacterException extends Exception {
	/**
	 * This is the Exception created when there's an invalid Character found in
	 * a file
	 * 
	 * @param string
	 *            takes the message that will be printed to the terminal.
	 */
	public InvalidCharacterException(String string) {
		System.out.print(string);
	}

}
