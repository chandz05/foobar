package zombit_monitoring_2;

public class Answer {
	public static int answer(int[][] intervals) {

		int rows = intervals.length; // to represent each minion monitor
		int columns = 2; // to represent the start and end times

		/*for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(intervals[i][j] + " ");
			}
			System.out.println();
		}*/
		
		//Get the start and end time of the first pair
		int firstNum = intervals[0][0];
		int secondNum = intervals[0][1];

		//Loop through the rows. If there is a starting time that is
		//less than the first time, overwrite
		//If there is an end time greater than the first time, overwrite
		for (int i = 0; i < rows; i++) {
			if (intervals[i][0] < firstNum) {
				firstNum = intervals[i][0];
			}
			if (intervals[i][1] > secondNum) {
				secondNum = intervals[i][1];
			}
		}
		
		//Find the difference to get the total time
		int total = secondNum - firstNum;

		return total;
	}
}
