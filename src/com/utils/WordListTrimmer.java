package com.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordListTrimmer {
	public static void main(String[] args) throws IOException {

		// read file of frequent words
		File inputFile = new File("configs/DodgyFrequentWords.txt");
		File outputFile = new File("configs/FiveLetterFrequentWords.txt");
		Scanner scanner = new Scanner(inputFile);
		FileWriter fw = new FileWriter(outputFile);

		// loop through line by line
		// if word length == 5

		while (scanner.hasNextLine()) {

			String word = scanner.nextLine();

			if (word.length() == 5) {

				fw.write(word + "\n");

			}

		}
		
		fw.close();
		scanner.close();

	}
}
