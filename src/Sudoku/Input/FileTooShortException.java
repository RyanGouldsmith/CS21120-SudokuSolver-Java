package Sudoku.Input;

public class FileTooShortException extends Exception {
	/**
	 * This is the exception which is thrown if the file is too short
	 * 
	 * @param string
	 *            is the message which will be outputted to the user
	 */
	public FileTooShortException(String string) {
		System.out.print(string);
	}

}
