import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// ACCUMULATING ANSWERS WITH MULTIPLE ANSWERS. WHEN DID THIS HAPPEN???
		// OUTPUT NEEDS TO BE RESET AFTER EACH GUESS

		String wordToGuess = "teeth";
		String outputString = "";
		StringBuilder output = new StringBuilder("");
		int guessCount = 0;

		do {
			output = new StringBuilder("");
			// initialise accumulators

			ArrayList<Character> letters = new ArrayList<>();

			// getting the user input - user guess
			System.out.println("Please enter a 5 letter word");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			input = input.toLowerCase();

			for (int i = 0; i < input.length(); i++) {

				char wordLetter = input.charAt(i);

				for (int j = 0; j < wordToGuess.length(); j++) {

					if (wordLetter == wordToGuess.charAt(j)) {

						if (i == j) {

							// logic for direct match
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

			System.out.println(output);

			outputString = output.toString();

			// REMOVE DUPLICATES FROM ARRAY LIST FIRST

//			ArrayList<Character> lettersToArray = new ArrayList<Character>();
//			 lettersToArray.addAll(letters);

			Iterator<Character> it = letters.iterator();

			int a = 0;

			while (it.hasNext()) {

				for (int i = 0; i < letters.size(); i++) {

					if (outputString.contains(letters.get(i) + "")) {
						letters.remove(letters.get(i));

					}

				}
				
				

			}

//			if (letters.size() > 0) {
//
////				int frequencyInWordToGuess = 0;
////				int frequencyInOutput = 0;
////				int frequencyInInput = 0;
//
//				int a = letters.size();

//				for (int i = 0; i < letters.size(); i++) {
//
//					for (int j = 0; j < wordToGuess.length(); j++) {
//
//						if (letters.get(i) == wordToGuess.charAt(j)) {
//							letters.remove(letters.get(i));
//							frequencyInWordToGuess++;
//							break;
//						}
//
////                                                                                            if (letters.get(i) == output.charAt(j)) {
////
////                                                                                                            frequencyInOutput++;
////                                                                                            }
////                                                                                            
////                                                                                            if (letters.get(i) == input.charAt(j)) {
////
////                                                                                                            frequencyInInput++;
////                                                                                            }
//
//					}
//
////                                                                            if (frequencyInWordToGuess == frequencyInOutput) {
////                                                                                            //letters.remove(letters.get(i));
////                                                                            }
//
//				}
				if (letters.size() > 0) {
					System.out.println("Correct letter, wrong position: " + letters);
				}
			//}

			outputString = output.toString();

			guessCount++;
		} while (!outputString.equals(wordToGuess));
		{

			System.out.println("You guessed correctly, well done!");
			System.out.println("You made " + guessCount + " guesses");

			// need logic that says if a character has already been guessed and is in right
			// index and it doesn't appear anywhere else then it
			// needs to be removed from the ARRAY LIST

			// PRINT OUT SEPARATE LINE WITH REMAINING GUESSES THAT WERE IN THE WRONG PLACE

			// need ACCUMULATOR OF COUNT using guess count

			// PRINT OUT INCREMENT - number of tries

			// IS THE INPUT 5*** LETTERS

			// AFTER THOUGHT - IS INPUT A VALID WORD? INPUT WORD LIST ... OTHERWISE SYSOUT
			// NOT A VALID WORD

			// LASTLY - SYSOUT RULES AT START

		}
	}
}
