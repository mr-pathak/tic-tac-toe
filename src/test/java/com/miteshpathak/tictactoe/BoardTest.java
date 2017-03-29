package com.miteshpathak.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Board.
 */
public class BoardTest {
	private final int givenGridSize = 3;
	// Represents as [2, 2] in a matrix
	private final int numberRepLastCell = 9;
	private final int expectedRow = 2;
	private final int expectedColumn = 2;

	@Test
	public void testGetNumericRepresentation() {
		Board board = new Board(givenGridSize);
		int obtainedNumber = board.getNumericRepresentation(expectedRow, expectedColumn);

		assertEquals(numberRepLastCell, obtainedNumber);
	}

	@Test
	public void testGetRowAndColumn() {
		Board board = new Board(givenGridSize);
		int obtainedRow = board.getRow(numberRepLastCell);
		int obtainedCol = board.getColumn(numberRepLastCell);

		assertEquals(expectedRow, obtainedRow);
		assertEquals(expectedColumn, obtainedCol);
	}

	@Test
	public void testMaxNumberRepresentation() {
		int expectedMaxNumberPossible = 9; // 3 *3
		Board board = new Board(givenGridSize);
		int obtainedMaxNumber = board.getMaxNumericRepresentation();

		assertEquals(expectedMaxNumberPossible, obtainedMaxNumber);
	}
}