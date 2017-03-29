package com.miteshpathak.tictactoe;

import static com.miteshpathak.tictactoe.Constants.*;

/**
 * This class represents, the Tic Tac Toe board.
 * Each cube/field on the board is represented by a unique number
 * 
 * @author Mitesh Pathak <miteshpathak05@gmail.com>
 */
public class Board {
	private static String UNDER_SCORES = "";
	private static String ROW_FORMAT = "";

	private String board[][];
	private int gridSize;
	private int maxNumericRepresentation;

	public Board(int gridSize) {
		ArgumentsValidator.checkInRange(gridSize, MIN_GRID_SIZE, MAX_GRID_SIZE, ERR_GRID_SIZE);
		this.gridSize = gridSize;
		this.maxNumericRepresentation = gridSize * gridSize;
		this.board = new String[gridSize][gridSize];
		initBoard();
		updatePrintFormat(gridSize, maxNumericRepresentation);
	}

	public void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = getNumericRepresentationString(i, j);
			}
		}
	}

	private String getNumericRepresentationString(int i, int j) {
		return String.valueOf(getNumericRepresentation(i, j));
	}

	public int getNumericRepresentation(int row, int column) {
		ArgumentsValidator.checkInRange(row, 0, gridSize, ERR_INVALID_ROW);
		ArgumentsValidator.checkInRange(column, 0, gridSize, ERR_INVALID_COL);

		return (row * gridSize) + (column + 1);
	}

	public int getColumn(int numericRepresentation) {
		ArgumentsValidator.checkInRange(numericRepresentation, 1,
				maxNumericRepresentation, ERR_INVALID_BOARD_NUM);
		return (numericRepresentation - 1) % gridSize;
	}

	public int getRow(int numericRepresentation) {
		ArgumentsValidator.checkInRange(numericRepresentation, 1,
				maxNumericRepresentation, ERR_INVALID_BOARD_NUM);
		return (numericRepresentation - 1) / gridSize;
	}

	public boolean isWinningMove(int rowPlayed, int columnPlayed, String value) {
		boolean won = isWinByRow(rowPlayed, value) || isWinByColum(columnPlayed, value) 
				|| isWinByDiagonal(rowPlayed, columnPlayed, value);
		return won;
	}

	private boolean isWinByRow(int row, String value) {
		int maxCount = 0;
		int continousCount = 0;
		for (int c = 0; c < gridSize; c++) {
			if (board[row][c].equals(value)) {
				continousCount++;
			} else {
				maxCount = Math.max(maxCount, continousCount);
				continousCount = 0;
			}
		}
		maxCount = Math.max(maxCount, continousCount);
		if (maxCount == WIN_COUNT) {
			return true;
		}
		return false;
	}

	private boolean isWinByColum(int column, String value) {
		int maxCount = 0;
		int continousCount = 0;
		for (int r = 0; r < gridSize; r++) {
			if (board[r][column].equals(value)) {
				continousCount++;
			} else {
				maxCount = Math.max(maxCount, continousCount);
				continousCount = 0;
			}
		}
		maxCount = Math.max(maxCount, continousCount);
		if (maxCount == WIN_COUNT) {
			return true;
		}
		return false;
	}

	private boolean isWinByDiagonal(int rowPlayed, int columnPlayed, String value) {
		// check for main diagonal
		if (rowPlayed == columnPlayed) {
			int maxCount = 0;
			int continousCount = 0;
			for (int i = 0; i < gridSize; i++) {
				if (board[i][i].equals(value)) {
					continousCount++;
				} else {
					maxCount = Math.max(maxCount, continousCount);
					continousCount = 0;
				}
			}
			maxCount = Math.max(maxCount, continousCount);
			if (maxCount == WIN_COUNT) {
				return true;
			}
		}

		// check for second diagonal
		if (rowPlayed == (gridSize - (columnPlayed + 1))) {
			int maxCount = 0;
			int continousCount = 0;
			for (int i = 0; i < gridSize; i++) {
				if (board[i][(gridSize - (i + 1))].equals(value)) {
					continousCount++;
				} else {
					maxCount = Math.max(maxCount, continousCount);
					continousCount = 0;
				}
			}
			maxCount = Math.max(maxCount, continousCount);
			if (maxCount == WIN_COUNT) {
				return true;
			}
		}
		return false;
	}

	public void setValue(int row, int column, String value) {
		String expectedBoardVal = getNumericRepresentationString(row, column);
		ArgumentsValidator.checkEquals(board[row][column], expectedBoardVal, ERR_BOARD_VALUE_SET);
		this.board[row][column] = value;
	}

	private static void updatePrintFormat(int gridSize, int maxNumRepresentation) {
		StringBuilder rowFormat = new StringBuilder();
		StringBuilder underScores = new StringBuilder();

		for (int i = 1; i < gridSize; i++) {
			rowFormat.append("%3s | ");
			underScores.append("------");
		}
		rowFormat.append("%3s");
		underScores.append("------");

		ROW_FORMAT = rowFormat.toString();
		UNDER_SCORES = underScores.toString();
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			System.out.println(String.format(ROW_FORMAT, (Object[]) board[i]));
			if (i < (gridSize - 1)) {
				System.out.println(UNDER_SCORES);
			}
		}
		System.out.println();
	}

	public int getMaxNumericRepresentation() {
		return maxNumericRepresentation;
	}


}
