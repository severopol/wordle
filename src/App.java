import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static String wordToGuess = "teeth";
	public static String outputString;

	public static void main(String[] args) {

		do {
   
			// initialise accumulators
			int guessCount = 0;

			ArrayList<Character> letters = new ArrayList<>();

			// getting the user input - user guess
			System.out.println("Please enter a 5 letter word");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			StringBuilder output = new StringBuilder("");
			input = input.toLowerCase();

			for (int i = 0; i < input.length(); i++) {

				char wordLetter = input.charAt(i);

				for (int j = 0; j < wordToGuess.length(); j++) {

					if (wordLetter == wordToGuess.charAt(j)) {

						if (i == j) {

							// logic for direct match
							output.append(wordToGuess.charAt(i));

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

			if (letters.size() > 0) {

				int frequencyInWordToGuess = 0;
				int frequencyInOutput = 0;
				int frequencyInInput = 0;

				for (int i = 0; i < letters.size(); i++) {

					for (int j = 0; j < wordToGuess.length(); j++) {

						if (letters.get(i) == wordToGuess.charAt(j)) {
							letters.remove(letters.get(i));
							frequencyInWordToGuess++;
							break;
						}

//                                                                                if (letters.get(i) == output.charAt(j)) {
//
//                                                                                                frequencyInOutput++;
//                                                                                }
//                                                                                
//                                                                                if (letters.get(i) == input.charAt(j)) {
//
//                                                                                                frequencyInInput++;
//                                                                                }

					}

//                                                                if (frequencyInWordToGuess == frequencyInOutput) {
//                                                                                //letters.remove(letters.get(i));
//                                                                }

				}
				if (letters.size() > 0) {
					System.out.println("Correct letter, wrong position: " + letters);
				}
			}

			outputString = output.toString();

		} while (!outputString.equals(wordToGuess));

		System.out.println("You guessed correctly!");

		// need logic that says if a character has already been guessed and is in right
		// index and it doesn't appear anywhere else then it
		// needs to be removed from the ARRAY LIST

		// IF WORD ISN'T RIGHT - GUESS AGAIN, IF IT IS RIGHT - YOU'VE GUESSED CORRECTLY.
		// ENDS GAME. GIVE COUNT.

		// check user input against constant

		// PRINT out result with asterisks in place of WRONG letters, letters they
		// guessed in RIGHT PLACE PRINTED IN

		// PRINT OUT SEPARATE LINE WITH REMAINING GUESSES THAT WERE IN THE WRONG PLACE

		// need ACCUMULATOR OF COUNT using guess count

		// BEFORE CAN COUNT GUESSES - NEED A WAY OF CHECKING IF WHOLE WORD IS CORRECT.
		// IF WORD IS GUESSED. LOOP NEEDS TO STOP. BOOLEAN?

		// PRINT OUT INCREMENT - number of tries

		// IS THE INPUT 5*** LETTERS

		// AFTER THOUGHT - IS INPUT A VALID WORD? INPUT WORD LIST ... OTHERWISE SYSOUT
		// NOT A VALID WORD

		// LASTLY - SYSOUT RULES AT START

	}
}
