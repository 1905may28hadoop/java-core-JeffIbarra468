package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/*
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * 
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration

		// Enters first index into acronym
		String acronym = "";

		// Makes sure acronym is ALL CAPS
		acronym = acronym + phrase.toUpperCase().charAt(0);

		// Will enter letter after each space
		for (int i = 1; i <= phrase.length() - 1; i++) {
			if (phrase.charAt(i - 1) == ' ' || phrase.charAt(i - 1) == '-') {
				acronym += phrase.toUpperCase().charAt(i);
			}
		}

//		System.out.println(acronym);

		return acronym;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		// initialize variables to empty or 0 -> no garbage values
		char str = '\0';
		int score = 0;

		for (int i = 0; i < string.length(); i++) { // gets each letter of word and accounts for upper case
			str = string.toLowerCase().charAt(i);

			// Passes each letter to calculate score given case
			switch (str) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 'r':
			case 's':
			case 't':
				score = score + 1;
				break;
			case 'd':
			case 'g':
				score += 2;
				break;
			case 'b':
			case 'c':
			case 'm':
			case 'p':
				score += 3;
				break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				score += 4;
				break;
			case 'k':
				score += 5;
				break;
			case 'j':
			case 'x':
				score += 8;
				break;
			case 'q':
			case 'z':
				score += 10;
				break;
			default:
				break;
			}
			// System.out.println("Score given letter " + str + " : " + score);
		} // end of score calculation

		// Final Score
//		System.out.println("Score of " + string + " : " + score);

		return score;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		int MAX_PHONE_NUM = 10; // Phone number limit

//		System.out.println("Entered string: " + string);

		// clearing any symbols
		for (int i = 0; i < string.length(); i++) {

			// Taking out symbols
			if ((string.charAt(i) == '(') | (string.charAt(i) == ')') | (string.charAt(i) == '-') | (string.charAt(i) == '.')) {
				string = string.replace(string.charAt(i), ' ');
			}
		}

		// Removes all white-spaces within phone number
		string = string.replaceAll("[\\s\\D]", "");
		
		if (string.length() != MAX_PHONE_NUM) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}

//		System.out.println("After: " + string);

		return string;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		// Created new map - key: String, value: Integer
		Map<String, Integer> Occurrence = new HashMap<>();
		Integer count = 1;
		Integer initial = 1;
		String[] word;

		word = string.split("[,\\s\\n]+");

		// System.out.println("Word List Below:"); // Puts all words into list
		for (int i = 0; i < word.length; i++) {

			if (Occurrence.get(word[i]) == null) {
				Occurrence.put(word[i], initial);

				// System.out.println(word[i]);
			} else {
				Occurrence.put(word[i], count += 1);
			}
		}

//		print(Occurrence);

		return Occurrence;
	}

	// used only to print out my map if needed
	private void print(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		if (map.isEmpty())
			System.out.println("Map is empty");
		else
			System.out.println(map);
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
/*
			Object[] compare = sortedList.toArray();

			int indexOf = 0;
			
			for (int i = 0; i < compare.length; i++) {

				// If compare and t indices match, return index
				if (t.equals(compare[i]))
					indexOf = i;
				
				// t is smaller, compare larger list
				if(compare[(compare.length/2)] > t[i]) {

					// Spilt up the array and call 
					// function to check larger set
				}
					
					
				// t is bigger, compare smaller list	
				if((compare.length/2) < t[i]) {

					// Spilt up the array and call 
					// function to check larger set
				}

	*/			
			return 0; // indexOf;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String in = Integer.toString(input);
		int armNum = 0;
		int base = 0;
		int expo = 0;

		// calculation for Armstrong number
		for (int i = 0; i < in.length(); i++) {

			// Turn the string index into proper number
			base = Character.getNumericValue(in.charAt(i));
			expo = (int) in.length();

			armNum += Math.pow(base, expo);
		}

//		System.out.println("Input: " + input);
//		System.out.println("ArmNum Result: " + armNum);

		// checks if input is armNum
		if (armNum == input)
			return true;
		else
			return false;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration

		List<Long> primeList = new ArrayList<Long>();

		// test prime number algorithm
		if (l == 2)
			primeList.add(l); // Two is its own prime factor
		else {

			for (long x = 2; x < l; x++) {

				while (l % x == 0) { // checks if number is divisible by prime 2
					primeList.add(x); // x is a prime factor
					l = l / x; // divide by x to get next non-factorize number
				}
			}
			if (l > 2) {
				primeList.add(l); // l is a prime factor
			}
		}

		return primeList;
	}

	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */

		static String plain = "abcdefghijklmnopqrstuvwxyz";
		static String cipher = "zyxwvutsrqponmlkjihgfedcba";

		public static String encode(String string) {
			// TODO Write an implementation for this method declaration

			String newStr = nonEncyptStr(string);

			String encyptStr = encypt(newStr);

			String finEnc = finalEncyrpt(encyptStr);

//			 System.out.println("FinStr:" + finEnc);

			return finEnc;
		}

		private static String finalEncyrpt(String fStr) {
			// StringBuffer sb = new StringBuffer(fStr);
			String temp = "";

			for (int i = 0; i < fStr.length(); i++) {

				// Every 5th index put space
				if ((i % 5 == 0) && (i != 0)) {
					temp += " ";
				}

				temp += fStr.charAt(i);
			}

			return temp;
		}

		private static String nonEncyptStr(String str1) {

			// lower case all strings before an encryp/decrypt happens
			str1 = str1.toLowerCase();
			String str2 = "";

			// Makes sure only letters/numbers are in the string
			str2 = str1.replaceAll("[^a-z0-9]+", "\0");
			str2 = str2.replaceAll("\0", "");

			return str2;
		}

		private static String encypt(String newStr) {
			String encWd = "";
			char nonEncCh; // non-encrypted character

			// iterate through the length of word
			for (int i = 0; i < newStr.length(); i++) {

				// Get letter from word
				nonEncCh = newStr.charAt(i);

				switch (nonEncCh) {

				case 'a':
					nonEncCh = 'z';
					break;
				case 'b':
					nonEncCh = 'y';
					break;
				case 'c':
					nonEncCh = 'x';
					break;
				case 'd':
					nonEncCh = 'w';
					break;
				case 'e':
					nonEncCh = 'v';
					break;
				case 'f':
					nonEncCh = 'u';
					break;
				case 'g':
					nonEncCh = 't';
					break;
				case 'h':
					nonEncCh = 's';
					break;
				case 'i':
					nonEncCh = 'r';
					break;
				case 'j':
					nonEncCh = 'q';
					break;
				case 'k':
					nonEncCh = 'p';
					break;
				case 'l':
					nonEncCh = 'o';
					break;
				case 'm':
					nonEncCh = 'n';
					break;
				case 'n':
					nonEncCh = 'm';
					break;
				case 'o':
					nonEncCh = 'l';
					break;
				case 'p':
					nonEncCh = 'k';
					break;
				case 'q':
					nonEncCh = 'j';
					break;
				case 'r':
					nonEncCh = 'i';
					break;
				case 's':
					nonEncCh = 'h';
					break;
				case 't':
					nonEncCh = 'g';
					break;
				case 'u':
					nonEncCh = 'f';
					break;
				case 'v':
					nonEncCh = 'e';
					break;
				case 'w':
					nonEncCh = 'd';
					break;
				case 'x':
					nonEncCh = 'c';
					break;
				case 'y':
					nonEncCh = 'b';
					break;
				case 'z':
					nonEncCh = 'a';
					break;
				default:
					break;
				}

				encWd += nonEncCh;
			}

			return encWd;
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration

			// Prepares the string to be decrypted
			String newStr = nonEncyptStr(string);

			// Encrypting and decrypting have the same algorithm
			String decyptStr = encypt(newStr);

//			System.out.println("FinStr:" + decyptStr);

			return decyptStr;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String cmd = "";
		Integer num1 = 0, num2 = 0, num3 = 0;
		int result = 0;

//		System.out.println(string);

		// Eliminate '?' char then parse string into words
		string = string.replaceAll("[?]", "");
		String[] parsed = string.split(" ");

		/*
		// checks for operator
		for (int i = 0; i < parsed.length; i++) {

			System.out.println(parsed[i]);
				
			// checks for operator
			if ((parsed[i].toString() == "plus") || (parsed[i].toString() == "minus")
					|| (parsed[i].toString() == "multiplied") || (parsed[i].toString() == "divided")) {
				System.out.println("If " + parsed[i]);
				cmd = parsed[i];
			}
				
		}
		*/
		
		cmd = parsed[3];
		num1 = Integer.parseInt(parsed[2]);
		
		switch (cmd) {

		case "plus":
			num2 = Integer.parseInt(parsed[4]);
			result = add(num1, num2);
			break;
		case "minus":
			num2 = Integer.parseInt(parsed[4]);
			result = subtract(num1, num2);
			break;
		case "multiplied":
			num3 = Integer.parseInt(parsed[5]);
			result = mult(num1, num3);
			break;
		case "divided":
			num3 = Integer.parseInt(parsed[5]);
			result = divide(num1, num3);
			break;
		default:
			System.out.println("Something wrong occured");
			break;
		}

		return result;
	}

	public static int add(int n1, int n2) {

		return n1 + n2;
	}

	public static int subtract(int n1, int n2) {

		return n1 - n2;
	}

	public static int mult(int n1, int n2) {

		return n1 * n2;
	}

	public static int divide(int n1, int n2) {

		return n1 / n2;
	}
}