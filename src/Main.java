

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
		int correctLines = 0;

		ArrayList<Character> characters = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();
		Scanner fs = new Scanner(new File("lines.txt"));
		while (fs.hasNextLine()) {
			String line = fs.nextLine();
			String characterName = line.substring(line.indexOf("\t") + 1).trim();
			String characterLine = line.substring(0, line.indexOf("\t")).trim();

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
				names.add(characterName);
			}
		}

		fs.close();

		Scanner sc = new Scanner(System.in);

		int mode = 0;
		System.out.println("Which mode would you like to try?");
		System.out.println("0: Mooney Mode (Only the one true Mooney can succeed at this)");
		System.out.println("1: Regular Mode (Easy)");
		System.out.print(": ");
		mode = sc.nextInt();

		if (mode != 0 && mode != 1) {
			System.out.println("Sorry, invalid mode!");
			sc.close();
			return;
		}

		System.out.println();
		System.out.println("To exit, type \"exit\". Answers are not case-sensitive.");
		System.out.println();

		sc.nextLine();

		while (characters.size() > 0) {
			int characterIndex = (int) (Math.random() * characters.size());
			Character randomCharacter = characters.get(characterIndex);
			String randomQuote = randomCharacter.getLines().remove((int) (Math.random() * randomCharacter.getLines().size()));

			if (randomCharacter.getLines().size() == 0) {
				characters.remove(characterIndex);
			}

			ArrayList<String> randomNames = new ArrayList<>();
			if (mode == 1) {
				randomNames.add(randomCharacter.getName());
				randomNames.add(names.get((int) (Math.random() * names.size())));
				randomNames.add(names.get((int) (Math.random() * names.size())));
			}

			System.out.println("___ said \"" + randomQuote + "\"");
			if (mode == 1) {
				System.out.println(randomNames.remove((int) (Math.random() * randomNames.size())));
				System.out.println(randomNames.remove((int) (Math.random() * randomNames.size())));
				System.out.println(randomNames.remove((int) (Math.random() * randomNames.size())));
			}
			System.out.print(": ");
			String answer = sc.nextLine();

			System.out.println();

			if (answer.toLowerCase().equals("exit")) {
				System.out.println("——————————————————————————————");
				System.out.println("Results: " + Math.round((((double) correctLines / (double) totalLines) * 100)) + "% Correct! With " + correctLines + " out of " + totalLines + "!");
				sc.close();
				return;
			}

			totalLines++;

			if (answer.toLowerCase().equals(randomCharacter.getName().toLowerCase())) {
				System.out.println("Yay! correct!");
				correctLines++;
			} else {
				System.out.println("Oh no, that is wrong... The correct answer is " + randomCharacter.getName());
			}
			System.out.println();
		}

		System.out.println("——————————————————————————————");
		System.out.println("Results: " + Math.round((((double) correctLines / (double) totalLines) * 100)) + "% Correct! With " + correctLines + " out of " + totalLines + "!");
		sc.close();
	}
}