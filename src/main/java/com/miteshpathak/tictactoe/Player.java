package com.miteshpathak.tictactoe;

public enum Player {
	X("X", "Player1"), O("O", "Player2");

	private String value;
	private String name;

	private Player(String value, String defauleName) {
		this.value = value;
		this.name = defauleName;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
