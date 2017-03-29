package com.miteshpathak.tictactoe;

import static com.miteshpathak.tictactoe.Constants.*;

/**
 * TicTacToe game engine
 * 
 * @author Mitesh Pathak <miteshpathak05@gmail.com>
 */
public class TicTacToe {
	private int maxMoves;
	private Player currentPlayer;
	private int totalMoves;
	private State gameState;
	private Board board;

	public TicTacToe(int gridSize) {
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
		ArgumentsValidator.checkEquals(gameState, State.PLAYING, ERR_GAME_FINISHED);
		int row = board.getRow(numericRepresentation);
		int column = board.getColumn(numericRepresentation);
		board.setValue(row, column, currentPlayer.getValue());
		totalMoves++;
		updateGameState(row, column);
	}

	private void updateGameState(int row, int column) {
		if (board.isWinningMove(row, column, currentPlayer.getValue())) {
			gameState = State.WON;
		} else  if (totalMoves == maxMoves) {
			gameState = State.DRAW;
		}
		if (gameState == State.PLAYING) {
			currentPlayer = getNextPlayer();
		}
	}

	public void printBoard() {
		board.printBoard();
	}

	public void printStatus() {
		if (gameState == State.WON) {
			System.out.println(String.format(WIN_MSG_FM,  currentPlayer.getName()));
		}
		if (gameState == State.DRAW) {
			System.out.println(DRAW_MSG);
		}
		if (gameState == State.PLAYING) {
			System.out.println(String.format(CONT_MSG_FM, currentPlayer.getName(), currentPlayer.getValue()));
		}
	}

	public State getGameState() {
		return gameState;
	}

	public void printResult() {
		if (gameState == State.PLAYING) {
			System.out.println("Game still in progress!");
		} else {
			printStatus();
		}
	}
}