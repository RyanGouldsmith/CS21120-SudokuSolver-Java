package jUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SudokuSolver.model.Square;

public class TestSquare {
	Square s;

	/**
	 * Creates a new square to use in testing
	 */
	@Before
	public void initalise() {
		s = new Square();
	}

	/**
	 * Checks to see if it can set a value to a given square
	 */
	@Test
	public void setValueToSquare() {
		s.setSquare(0, 3, 8);
		assertEquals(8, s.getSquare(0, 3));
	}

	/**
	 * checks to see if the square isn't null if we call the instance of it
	 */
	@Test
	public void checkSquareIsNotNull() {
		assertNotNull(s.getSquare());
	}

}
