package com.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

	public static void main(String[] args) throws FileNotFoundException {

		String wordToGuess = generateWord();
		String outputString = "";
		String outputPrint = "";
		StringBuilder output = new StringBuilder("");
		int guessCount = 0;
		ArrayList<Character> letters = new ArrayList<>();
		Scanner scanner;
		String input = "";
		boolean isWordCorrectLength = false;
		int characterLength;
		scanner = new Scanner(System.in);
		String chosenLength = "";
		boolean isValidNumber = false;
		int num = 0;
		System.out.println("Enter your desired word length between 4 and 10");

		while (!isValidNumber) {

			chosenLength = scanner.nextLine();
			num = Integer.parseInt(chosenLength);

			if (num >= 4 && num <= 10) {

				isValidNumber = true;

			} else {
				System.out.println("Length not between 4 and 10. Please enter again.");
			}
		}

		do {
			output = new StringBuilder("");

			// getting the user input - user guess OR asking user to guess again
			if (guessCount > 0)
				System.out.println("Guess again:\n");
			else {
				System.out.println("Please enter a " + num + " letter word.\n");
			}

			// while loop for validating length of input string
			while (!isWordCorrectLength) {

				input = scanner.nextLine();

				if (input.length() == num) {

					isWordCorrectLength = true;

				} else {

					System.out.println("Wrong word length. Please enter a " + num + " letter word.\n");
				}
			}

			input = input.toLowerCase();

			for (int i = 0; i < input.length(); i++) {

				char wordLetter = input.charAt(i);

				for (int j = 0; j < wordToGuess.length(); j++) {

					if (wordLetter == wordToGuess.charAt(j)) {
						if (i == j) {

							output.append(wordToGuess.charAt(i));
							break;
						} else {
							letters.add(wordLetter);
						}
					}
				}

				if (output.length() == i) {
					output.append("*");
				}
			}

			outputString = output.toString();
			outputPrint = output.toString().toUpperCase();
			System.out.println(outputPrint);

			// REMOVE DUPLICATES FROM ARRAY LIST
			Iterator<Character> it = letters.iterator();
			ArrayList<Character> reducedList = new ArrayList<>();
			reducedList.addAll(letters);

			while (it.hasNext()) {

				it.next();

				for (int i = 0; i < letters.size(); i++) {

					if (outputString.contains(letters.get(i) + "")) {

						reducedList.remove(letters.get(i));
					}
				}
				it.remove();
			}

			Set<Character> set = new LinkedHashSet<Character>(reducedList);
			reducedList.clear();
			reducedList.addAll(set);

			if (!reducedList.isEmpty()) {
				System.out.println("Correct letter, wrong position: " + reducedList + "\n");
			} else {
				System.out.println("\n");
			}

			guessCount++;

			isWordCorrectLength = false;

		} while (!outputString.equals(wordToGuess));

		System.out.println("You guessed correctly, well done!");
		System.out.println("You made " + guessCount + " guesses");
		scanner.close();
	}

	private static String generateWord() throws FileNotFoundException {

		File file = new File("configs/FiveLetterFrequentWords.txt");
		Scanner scanner = new Scanner(file);
		int rand = (int) ((Math.random() * (686 - 1)) + 1);
		int count = 1;

		while (scanner.hasNextLine() && count < rand) {
			String l = scanner.nextLine();
			count++;
		}

		String toReturn = scanner.nextLine().toLowerCase();
		scanner.close();

		return toReturn;

	}
}
