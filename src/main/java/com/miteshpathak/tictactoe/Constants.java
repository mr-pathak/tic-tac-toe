package com.miteshpathak.tictactoe;

public class Constants {
	public static final String ERR_GRID_SIZE = "Grid size is expected to be between 3 and 10";
	public static final String ERR_NAME_SIZE = "Name characters cannot exceed 48";
	public static final String ERR_GAME_FINISHED = "Game already finished";
	public static final String ERR_BOARD_VALUE_SET = "The board value is already set";
	public static final String ERR_INVALID_BOARD_NUM = "Invalid number for grid";
	public static final String ERR_PARSE_INT = "Failed to read value, expected integer";
	public static final String ERR_INVALID_ROW = "Invalid row provided";
	public static final String ERR_INVALID_COL = "Invalid column provided";
	public static final String ERR_INIT_FAILED = "[ERROR] Failed to Initialize Game";

	public static final String GET_GRID_SIZE = "Please enter GRID size (N) or press ENTER to set default value (= 3)";
	public static final String GET_PLY_ONE_NAME = "Please enter Player1's name (X) or press ENTER to skip";
	public static final String GET_PLY_TWO_NAME = "Please enter Player2's name (O) or press ENTER to skip";

	
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static final String WARN_INVALID_MOVE = "[WARN] Invalid move: ";
	public static final String START_GAME = "Let the game begin!";
	public static final String CONSOLE_IN = ">> ";

	public static final String DRAW_MSG = "Its a DRAW folks! ";
	public static final String WIN_MSG_FM = "%s wins! ";
	public static final String CONT_MSG_FM = "Its %s turns to play (%s)";

	public static final int WIN_COUNT = 3;
	public static final int MIN_GRID_SIZE = 3;
	public static final int MAX_GRID_SIZE = 10;
	public static final int MAX_NAME_SIZE = 48;
}
