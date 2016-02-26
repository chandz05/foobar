package minion_interrogation_3;

public class Answer {
	public static int[] answer(int[][] minions) {
		
		//Create an array to keep track of minion number. This will be our return array
		int[] ansArr = new int[minions.length];

		for (int i = 0; i < minions.length; i++) {
			ansArr[i] = i;
		}

		// Temporary variables to help swap values in the list
		int[] temp;
		int temp2;

		double Pa;
		int time;
		int time2;

		// This is basically just a modified bubble sort
		for (int i = 0; i < minions.length - 1; i++) {
			for (int j = 1; j < minions.length - i; j++) {

				Pa = (double) minions[j - 1][1] / minions[j - 1][2];
				time = minions[j - 1][0];
				time2 = minions[j][0];

				// Get the time of interrogating previous minion first
				double firstNum = Pa * time + (1 - (Pa)) * (time + time2);

				Pa = (double) minions[j][1] / minions[j][2];
				time = minions[j][0];
				time2 = minions[j - 1][0];

				// Get the time of interrogating next minion first
				double secondNum = Pa * time + (1 - (Pa)) * (time + time2);

				// Compare the times, and put smaller time first
				if (firstNum > secondNum) {
					temp = minions[j - 1];
					minions[j - 1] = minions[j];
					minions[j] = temp;

					temp2 = ansArr[j - 1];
					ansArr[j - 1] = ansArr[j];
					ansArr[j] = temp2;
				}

				// Otherwise, if the values are equal, do the following:
				else if (firstNum == secondNum) {
					// The values need to be lexicographically sorted, so
					// compare the values and swap if needed
					if (ansArr[j - 1] > ansArr[j]) {
						temp = minions[j - 1];
						minions[j - 1] = minions[j];
						minions[j] = temp;

						temp2 = ansArr[j - 1];
						ansArr[j - 1] = ansArr[j];
						ansArr[j] = temp2;
					}
				}
			}
		}

		return ansArr;

	}

}
