package com.macbeth;

import java.util.ArrayList;

public class Character {
	private String name;
	private ArrayList<String> lines;

	public Character(String name) {
		this.name = name;
		this.lines = new ArrayList<>();
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public String getName() {
		return name;
	}
	
	public void addLine(String line) {
		lines.add(line);
	}
}
