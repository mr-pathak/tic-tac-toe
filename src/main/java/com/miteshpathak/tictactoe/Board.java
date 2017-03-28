package com.miteshpathak.tictactoe;

public class Board {
	private static final String EMPTY = "";
	private static String UNDER_SCORES = "";
	private static String ROW_FORMAT = "";

	private String board[][];
	private int gridSize;
	private int maxNumericRepresentation;

	public Board(int gridSize) {
		if (gridSize < 3 || gridSize > 10) {
			throw new RuntimeException("Grid size is expected to be between 3 and 10");
		}
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
		return EMPTY + getNumericRepresentation(i, j);
	}

	public int getNumericRepresentation(int row, int column) {
		if (row < 0 || row >= gridSize || column < 0 || column >= gridSize) {
			throw new RuntimeException("Invalid row and/or column");
		}
		return (row * gridSize) + (column + 1);
	}

	public int getColumn(int numericRepresentation) {
		if (numericRepresentation < 1 || numericRepresentation > maxNumericRepresentation) {
			throw new RuntimeException("Invalid number for grid");
		}
		return (numericRepresentation - 1) % gridSize;
	}

	public int getRow(int numericRepresentation) {
		if (numericRepresentation < 1 || numericRepresentation > maxNumericRepresentation) {
			throw new RuntimeException("Invalid number for grid");
		}
		return (numericRepresentation - 1) / gridSize;
	}

	public boolean isWinningMove(int rowPlayed, int columnPlayed, String value) {
		boolean won = isWinByRow(rowPlayed, value) || isWinByColum(columnPlayed, value) 
				|| isWinByDiagonal(rowPlayed, columnPlayed, value);
		return won;
	}

	private boolean isWinByRow(int row, String value) {
		int maxCount = 0;
		for (int c = 0; c < gridSize; c++) {
			if (board[row][c].equals(value)) {
				maxCount++;
			}
		}
		if (maxCount == 3) {
			return true;
		}
		return false;
	}

	private boolean isWinByColum(int column, String value) {
		int maxCount = 0;
		for (int r = 0; r < gridSize; r++) {
			if (board[r][column].equals(value)) {
				maxCount++;
			}			
		}
		if (maxCount == 3) {
			return true;
		}
		return false;
	}

	private boolean isWinByDiagonal(int rowPlayed, int columnPlayed, String value) {
		// check for main diagonal
		if (rowPlayed == columnPlayed) {
			int maxCount = 0;
			for (int i = 0; i < gridSize; i++) {
				if (board[i][i].equals(value)) {
					maxCount++;
				}			
			}
			if (maxCount == 3) {
				return true;
			}
		}

		// check for second diagonal
		if (rowPlayed == (gridSize - (columnPlayed + 1))) {
			int maxCount = 0;
			for (int i = 0; i < gridSize; i++) {
				if (board[i][(gridSize - (i + 1))].equals(value)) {
					maxCount++;
				}			
			}
			if (maxCount == 3) {
				return true;
			}
		}
		return false;
	}

	public void setValue(int row, int column, String value) {
		if (!board[row][column].equals(getNumericRepresentationString(row, column))) {
			throw new RuntimeException("The board value is already set");
		}
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

		// System.out.println("[INFO] Setting format to " + rowFormat);
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
