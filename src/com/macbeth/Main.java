package com.macbeth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("███    ███  █████   ██████ ██████  ███████ ████████ ██   ██ ");
		System.out.println("████  ████ ██   ██ ██      ██   ██ ██         ██    ██   ██ ");
		System.out.println("██ ████ ██ ███████ ██      ██████  █████      ██    ███████ ");
		System.out.println("██  ██  ██ ██   ██ ██      ██   ██ ██         ██    ██   ██ ");
		System.out.println("██      ██ ██   ██  ██████ ██████  ███████    ██    ██   ██ ");
		System.out.println();

		int totalLines = 0;

		ArrayList<Character> characters = new ArrayList<>();
		Scanner fs = new Scanner(new File("lines.txt"));
		while (fs.hasNextLine()) {
			String line = fs.nextLine();
			String characterName = line.substring(line.indexOf("\t"));
			String characterLine = line.substring(0, line.indexOf("\t"));

			totalLines++;

			boolean isInArray = false;
			for (Character character : characters) {
				if (character.getName().equals(characterName)) {
					character.addLine(characterLine);
					isInArray = true;
				}
			}

			if (!isInArray) {
				characters.add(new Character(characterName));
				characters.get(characters.size() - 1).addLine(characterLine);
			}
		}

		fs.close();

		Scanner sc = new Scanner(System.in);

		int mode = 0; // 0 is mooney mode, 1 is regular
		System.out.println("Which mode would you like to try?");
		System.out.println("0: Mooney Mode (Only the one true Mooney can succeed at this)");
		System.out.println("1: Regular Mode (Easy)");
		System.out.print(": ");
		mode = sc.nextInt();

		switch (mode) {
			case 0:

				break;
			case 1:

				break;
			default:
				System.out.println("Sorry, invalid mode!");
				break;
		}

		sc.close();
	}
}