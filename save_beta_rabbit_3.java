package save_beta_rabbit_3;

public class Answer {
	
	public static int answer(int food, int[][] grid) {

		//Count total amount of food used
		int total = 0;

		//Get number of rows and columns in the grid
		int rows = grid.length;
		int columns = grid[0].length;
		
		//Variables to keep track of current row and column
		int i = 0;
		int j = 0;
		
		int temp1 = 0;
		int temp2 = 0;
		
		food += grid[i][j];
		
		
		//Loops through the grid while we have rows and columns left to loop
		do {
			//Exit the loop if we're at the bottom right square of the grid
			//(We've already accounted for that zombie below)
			if ((i == rows - 1) && (j == columns - 1))
				break;
			
			//First check if we're at the right-most column or the bottom-most row
			//If we are, only either increment the column or row (and feed zombie)
			if (i == rows - 1) {
				j++;
				total += grid[i][j];
				//answer(food, grid);
			} else if (j == columns - 1) {
				i++;
				total += grid[i][j];
				//answer(food, grid);
			}
			//otherwise, check the cell to the right and bottom. If the zombie fits what we need,
			//traverse to that cell (and feed zombie)
			else {
				if(grid[i][j+1] > grid[i+1][j]){
					if((total + grid[i][j+1]) < food){
						total += grid[i][j+1];
						j++;
					}
					else{
						total += grid[i+1][j];
						i++;
					}
				}
				else{
					if(grid[i+1][j] > grid[i][j+1]){
						if((total + grid[i+1][j]) < food){
							total += grid[i+1][j];
							i++;
						}
						else{
							total += grid[i][j+1];
							j++;
						}
					}
					else{
						if (grid[i+1][j] == grid[i][j+1]){
							total += grid[i+1][j];
							i++;
						}
					}
				}					
			 }
		} while (i < rows && j < columns);
		
		if (total <= food)
			return food - total;
		else
			return -1;
	}
}