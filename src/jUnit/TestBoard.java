package jUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SudokuSolver.model.Board;
import SudokuSolver.model.Square;

public class TestBoard {
	Board board;
	Square s;

	/**
	 * Initalises the board, so I can use these instance variables throughout
	 */
	@Before
	public void initalise() {
		board = new Board();
		s = new Square();
	}

	/**
	 * Checks to see if when returning a square from the board it's not null
	 */
	@Test
	public void checkIfReturnsSquare() {
		assertNotNull(board.getSquare());
	}

	/**
	 * Checks to see if the length of the board is 9
	 */
	@Test
	public void getLengthOfBoard() {
		assertEquals(9, board.getLength());
	}

	/**
	 * Checks to see If there's a number in the box that is not equal to 0
	 */
	@Test
	public void BoxIsFree() {
		board.getSquare().setSquare(0, 1, 1);
		assertFalse(board.isNumberInBox(0, 0));
	}

	/**
	 * Checks to see If there's a number in the box that is not equal to 0
	 */
	@Test
	public void BoxIsNotFree() {
		board.getSquare().setSquare(0, 1, 1);
		assertTrue(board.isNumberInBox(0, 1));
	}

	/**
	 * Checks to see If there's a number in the box that is not equal to 0
	 */
	@Test
	public void ColIsFree() {
		board.getSquare().setSquare(2, 1, 1);
		assertFalse(board.isNumberInColumn(1, 1));
	}

	/**
	 * Checks to see If there's a number in the box that is not equal to 0
	 */
	@Test
	public void ColIsNotFree() {
		board.getSquare().setSquare(2, 1, 1);
		assertTrue(board.isNumberInColumn(2, 1));
	}

	/**
	 * Checks to see If there's a number in the box that is not equal to 0
	 */
	@Test
	public void RowIsFree() {
		board.getSquare().setSquare(3, 1, 1);
		assertFalse(board.isNumberInBox(2, 0));
	}

	/**
	 * Checks to see If there's a number in the box that is not equal to 0
	 */
	@Test
	public void RowIsNotFree() {
		board.getSquare().setSquare(3, 1, 1);
		assertTrue(board.isNumberInBox(3, 1));
	}

	/**
	 * Checks to see if all the values have a number in, which is above 0.
	 */
	@Test
	public void checkIsComplete() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board.getSquare().setSquare(i, j, 1);
			}
		}
		assertTrue(board.isComplete());
	}

	/**
	 * Checks to see if the values in board are above 0. If they're not it will
	 * return false
	 */
	@Test
	public void checkIsNotComplete() {
		board.getSquare().setSquare(2, 4, 1);
		assertFalse(board.isComplete());
	}
}
