package com.miteshpathak.tictactoe;

import java.util.Scanner;

/**
 * Tic Tac Toe
 *
 */
public class Application {
	public static void main( String[] args ) {
		try (Scanner console = new Scanner(System.in)) {
			TicTacToe game = new TicTacToe(3);
			String name = null;

			System.out.println("Please enter Player1's name (X) or ENTER to skip");
			name = readString(console);
			if (!name.isEmpty())
				game.setPlayerOne(name);
			
			System.out.println("Please enter Player2's name (O) or ENTER to skip");
			name = readString(console);
			if (!name.isEmpty())
				game.setPlayerTwo(name);

			while (game.getGameState() == State.PLAYING) {
				game.printBoard();
				game.printState();
				int move = readInt(console);
				game.play(move);
			}
			
			game.printResult();
			game.printBoard();
		} catch (Exception e) {
			System.out.println("[ERROR] Failed to initialize to read from console");
			e.printStackTrace(System.err);
		}
	}
	
	private static String readString(Scanner console) {
		System.out.print(">> ");
		return console.nextLine();
	}
	private static int readInt(Scanner console) {
		return Integer.parseInt(readString(console));
	}
}
