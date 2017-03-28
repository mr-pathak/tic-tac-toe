package com.miteshpathak.tictactoe;

public class TicTacToe {
	private int maxMoves;
	private Player currentPlayer;
	private int totalMoves;
	private State gameState;
	private Board board;

	public TicTacToe(int gridSize) {
		if (gridSize < 3 || gridSize > 10) {
			throw new RuntimeException("Grid size is expected to be between 3 and 10");
		}
		this.board = new Board(gridSize);
		this.maxMoves = board.getMaxNumericRepresentation();
		initGame();
	}

	private void initGame() {
		// Player X starts first
		board.initBoard();
		currentPlayer = Player.X;
		totalMoves = 0;
		gameState = State.PLAYING;
	}

	public Player getNextPlayer() {
		if (currentPlayer == Player.X) {
			return Player.O;
		}
		return Player.X;
	}

	public void setPlayerOne(String name) {
		Player.X.setName(name);
	}

	public void setPlayerTwo(String name) {
		Player.O.setName(name);
	}


	public void play(int numericRepresentation) {
		if (gameState != State.PLAYING) {
			throw new RuntimeException("Game already finished");
		}
		totalMoves++;
		int row = board.getRow(numericRepresentation);
		int column = board.getColumn(numericRepresentation);
		board.setValue(row, column, currentPlayer.getValue());
		updateGameState(row, column);
	}

	private void updateGameState(int row, int column) {
		if (board.isWinningMove(row, column, currentPlayer.getValue())) {
			gameState = State.WON;
		}
		if (totalMoves == maxMoves) {
			gameState = State.DRAW;
		}
		if (gameState == State.PLAYING) {
			currentPlayer = getNextPlayer();
		}
	}

	public void printBoard() {
		board.printBoard();
	}

	public void printState() {
		if (gameState == State.WON) {
			System.out.println(currentPlayer.getName() + " wins!");
		}
		if (gameState == State.DRAW) {
			System.out.println("Its a DRAW folks!");
		}
		if (gameState == State.PLAYING) {
			System.out.println("Its " + currentPlayer.getName() + " turns to play");
		}
	}

	public State getGameState() {
		return gameState;
	}

	public void printResult() {
		if (gameState == State.PLAYING) {
			System.out.println("Game still in progress!");
		} else {
			printState();
		}
	}
}