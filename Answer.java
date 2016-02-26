package rabbit_test_subjects_1;

import java.util.Arrays;

public class Answer {
	public static int answer(double[] y, double[] x) {
		
		//Get the lengths of the lists
		double ylength = y.length;
		double xlength = x.length;
		
		//Check if the list lengths are the same. Every "before" time should have an "after" time
		if (ylength != xlength){
			System.out.println("List lengths are not equal");
			return 0;
		}
		
		//Check if the lists are within constraints (non-zero and less than 100)
		//Only one list needs to be checked, since we've already established that they're the same length
		if (ylength < 1 || ylength > 100)
		{
			System.out.println("Lists are not within size constraints");
			return 0;
		}
		
		//Sort the lists - this will make it easier to compare times
		Arrays.sort(y);
		Arrays.sort(x);
		
		double avg = 0;
		
		//This loop runs through each value in both arrays, calculating the percent increase between each pair and adding the 
		//answer to a total amount
		for (int i=0; i < ylength; i++){
			//We don't know which list contains the start times and which contains the end times, so we do a quick compare between
			//the two values
			if (x[i] < y[i]){
				avg = avg + (100 - (100/(y[i]/x[i])));
			}
			else
				avg = avg + (100 - (100/(x[i]/y[i])));
		}
		
		//We then find the average of all percentages...
		avg = avg/ylength;
		
		//...and round to the nearest int
		int totalavg = (int) Math.round(avg);
		
		return totalavg;
	}

}
