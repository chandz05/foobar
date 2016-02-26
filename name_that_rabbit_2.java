package name_that_rabbit_2;

public class Answer {

	public static String[] answer(String[] names) {

		// Temporary variable to help swap values in the list
		String temp;

		// This is basically just a modified descending bubble sort
		for (int i = 0; i < names.length - 1; i++) {
			for (int j = 1; j < names.length - i; j++) {

				// Get the numerical value of the current name in the list
				int firstNum = 0;
				for (int k = 0; k < names[j - 1].length(); k++) {
					// Because I'm using the ASCII value of the letters, each
					// letter has an
					// additional weighting of 96, which messes with the math
					// when added together
					// So I just negate the 96 here
					firstNum = firstNum + names[j - 1].charAt(k) - 96;
				}

				// Get the numerical value of the next name in the list
				int secondNum = 0;
				for (int k = 0; k < names[j].length(); k++) {
					secondNum = secondNum + names[j].charAt(k) - 96;
				}

				// If the numerical value of the first name is less than that of
				// the next name, swap the values
				if (firstNum < secondNum) {
					temp = names[j - 1];
					names[j - 1] = names[j];
					names[j] = temp;
				}

				// Otherwise, if the values are equal, do the following:
				else if (firstNum == secondNum) {
					// The values need to be lexicographically sorted, so
					//compare the strings and swap if needed
					if (names[j - 1].compareTo(names[j]) < 0) {
						temp = names[j - 1];
						names[j - 1] = names[j];
						names[j] = temp;
					}
				}
			}
		}

		return names;
	}
}
