package main.java.com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.concurrent.Task;

/**
 * Created by aamado on 05-05-2022. Edited by Gu1D4niel on 21-05-2022.
 * For further information on the project, please read the README.txt file.
 */
class ScreenLockinPattern extends CallableTask implements IScreenLockinPattern {
	
	public ScreenLockinPattern() throws InterruptedException, ExecutionException {
		
		Future<Integer> future = new ScreenLockinPattern().countPatternsFrom(0, 0);
		while (!future.isDone()) {
			System.out.println("Still Processing...");
			Thread.sleep(400);
		}
		
		Integer result = future.get();
	}

	// Matrix that represents the pattern scheme on phones.
		int[][] patternMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

	// Creation of a single thread executor
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	/**
	 * Method to count patterns from firstPoint with the length
	 * 
	 * @param firstPoint initial matrix position
	 * @param length     the number of points used in pattern
	 * @return number of patterns
	 */
	public Future<Integer> countPatternsFrom(int firstPoint, int length) {
		
		Future<Integer> result = executor.submit(new CallableTask());
		return result;
	}

	/**
	 * Integer value that represents the position of the first point in the Pattern.
	 * This value must not be less than 1 nor greater than 9
	 * 
	 * @return number of the position
	 */
	public int firstPoint(int num) {
		// "If" statement to ensure that the number is within acceptable bounds.
		// (NOTE: This statement can be improved with a "Try - Catch" statement,
		// so it automatically prompts the user with a new number)
		int value = 0;
		try {
			if (num < 0 || num >= 9) {
				System.out.println("This number is invalid");
				System.out.println("Please select a number between 1 and 9");
			} else {
				value = num;
			}
		} catch (InputMismatchException e) {
			if (e.getMessage() == null) {
				System.out.println("The number must not be writen in full");
				System.out.println(
						"Eg: '2' is a correct input for the number \n" + "'two' is an incorrect input ofr the number");
			} else {
				System.out.println(e.getMessage());
			}
		}
		return value;
	}

	/**
	 * Integer value that represents the size of the Pattern This value must not be
	 * less than 1 nor greater than 9
	 * 
	 * @return number of points to include
	 */
	public int length(int num) {

		// "If" statement to ensure that the number is within acceptable bounds.
		// (NOTE: This statement can be improved with a "Try - Catch" statement,
		// so it automatically prompts the user with a new number)
		int value = 0;
		try {
			if (num < 0 || num >= 9) {
				System.out.println("This number is invalid");
				System.out.println("Please select a number between 1 and 9");
			} else {
				value = num;
			}
		} catch (InputMismatchException e) {
			if (e.getMessage() == null) {
				System.out.println("The number must not be writen in full");
				System.out.println(
						"Eg: '2' is a correct input for the number \n" + "'two' is an incorrect input ofr the number");
			} else {
				System.out.println(e.getMessage());
			}
		}
		return value;
	};

	public boolean validNextPoint(int[][] patternMatrix, int firstpoint) {

		// List of already selected points, to avoid repetition, and allow overlap
		List<Integer> alreadyselected = new ArrayList<>();
		int currentpoint, nextpoint = 0, i, j;
		int row = 0, col = 0;
		// locate the first point in the matrix
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (patternMatrix[i][j] == firstpoint) {
					// identify the column and row in witch the element is
					row = i;
					col = j;
					System.out.println("the first point is in the row" + row + "and column" + col);
				}
			}
		}

		alreadyselected.add(firstpoint);
		// isto e sempre verdade, corrigir!!
		if (patternMatrix[row][col] + 1 == firstpoint + 1 && !alreadyselected.contains(nextpoint)) {
			// TODO
		}
		// Gui idk if this is it bro..
		return false;

	}
}

