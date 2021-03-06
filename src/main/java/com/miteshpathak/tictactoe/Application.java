package com.miteshpathak.tictactoe;

import java.util.Scanner;

import static com.miteshpathak.tictactoe.Constants.*;

/**
 * Tic Tac Toe entry point
 * This class interacts with user and uses {@code TicTacToe} to play the game
 *
 * @author Mitesh Pathak <miteshpathak05@gmail.com>
 */
public class Application {

	public static void main( String[] args ) {
		try (Scanner console = new Scanner(System.in)) {
			System.out.println(GET_GRID_SIZE);
			String gridSizeString = readString(console);
			int gridSize = MIN_GRID_SIZE;
			if (!gridSizeString.isEmpty()) {
				gridSize = parseInt(gridSizeString);
			}
			ArgumentsValidator.checkInRange(gridSize, MIN_GRID_SIZE, MAX_GRID_SIZE, ERR_GRID_SIZE);

			TicTacToe game = new TicTacToe(gridSize);
			String name = null;

			System.out.println(GET_PLY_ONE_NAME);
			name = readString(console);
			if (!name.isEmpty()) {
				ArgumentsValidator.checkValidString(name, MAX_NAME_SIZE, ERR_NAME_SIZE);
				game.setPlayerOne(name);
			}
			System.out.println(GET_PLY_TWO_NAME);
			name = readString(console);
			if (!name.isEmpty()) {
				ArgumentsValidator.checkValidString(name, MAX_NAME_SIZE, ERR_NAME_SIZE);
				game.setPlayerTwo(name);
			}

			// Let the game begin
			System.out.println();
			System.out.println(START_GAME);
			while (game.getGameState() == State.PLAYING) {
				try {
					game.printBoard();
					game.printStatus();
					int move = readInt(console);
					game.play(move);
					System.out.println();
				} catch (RuntimeException ex) {
					System.out.print(WARN_INVALID_MOVE);
					System.out.println(ex.getMessage());
				}
			}

			// print result
			game.printResult();
			game.printBoard();
		} catch (Exception e) {
			System.out.println(ERR_INIT_FAILED);
			e.printStackTrace(System.out);
		}
	}

	private static int parseInt(String integer) {
		try {
			return Integer.parseInt(integer);
		} catch (Exception ex) {
			throw new RuntimeException(Constants.ERR_PARSE_INT);
		}
	}

	private static String readString(Scanner console) {
		System.out.print(CONSOLE_IN);
		return console.nextLine();
	}

	private static int readInt(Scanner console) {
		return parseInt(readString(console));
	}
}
