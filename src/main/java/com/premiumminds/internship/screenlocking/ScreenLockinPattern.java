package main.java.com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Created by aamado on 05-05-2022. Edited by Gu1D4niel on 21-05-2022.
 * For further information on the project, please read the README.txt file.
 */
class ScreenLockinPattern extends CallableTask implements IScreenLockinPattern {
	//class constructor
	public ScreenLockinPattern() throws InterruptedException, ExecutionException {
		
		Future<Integer> future = new ScreenLockinPattern().countPatternsFrom(0, 0);
		while (!future.isDone()) {
			System.out.println("Still Processing...");
			Thread.sleep(400);
		}
		//return the final number
		Integer result = future.get();
	}

	// Matrix that represents the pattern scheme on phones.
	// This variable ended up not being used.
		int[][] patternMatrix = { { 1, 2, 3 }, 
								  { 4, 5, 6 }, 
								  { 7, 8, 9 } };

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
		
		//Future<Integer> result = executor.submit(new Callable<Integer>());
		
		return null;
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
			if (num < 0 || num > 9) {
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
			if (num < 1 || num > 9) {
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
	
	/**
	 * method that sets the rules for navigation inside the matrix, using cardinal points as reference
	 * on how to manipulate the rows and columns in the matrix. Ex.: if the point in the matrix is
	 * in the first row "([1, 2, 3])", it must be impossible to navigate North. 
	 * @param point the current point in the matrix
	 * @return
	 */
	public List<String> whatsForbiden(int firstpoint) {
		List<String> forbiden = new ArrayList<>();
		if (firstpoint == 1 || firstpoint == 2 || firstpoint == 3) {
			forbiden.add("N");
		} else if (firstpoint == 4 || firstpoint == 5 || firstpoint == 6) {
			forbiden.add("NN");
			forbiden.add("SS");
		} else if (firstpoint == 7 || firstpoint == 8 || firstpoint == 9) {
			forbiden.add("S");
		}
		
		if (firstpoint == 1 || firstpoint == 4 || firstpoint == 7) {
			forbiden.add("O");
		} else if (firstpoint == 2 || firstpoint == 5 || firstpoint == 8) {
			forbiden.add("EE");
			forbiden.add("OO");
		} else if (firstpoint == 3 || firstpoint == 6 || firstpoint == 9) {
			forbiden.add("E");
		}
		
		return forbiden;
	}

	/**
	 * Method that defines every possible ways of navigation available, and then applies the
	 * prohibitions defined on whatsForbiden.
	 * @return
	 */
	public List<Integer> possibleWays(int firstpoint, List<Integer> history) {
			
			List<String> forbiden = this.whatsForbiden(firstpoint);
			System.out.println("neste ponto, as direcoes proibidas sao: " + forbiden);
			System.out.println("o historico atual: " + history);
			
			List<String> directions = new ArrayList<>();
			directions.add("N");
			directions.add("S");
			directions.add("E");
			directions.add("O");
			directions.add("NE");
			directions.add("NNE");
			directions.add("NEE");
			directions.add("NO");
			directions.add("NNO");
			directions.add("NOO");
			directions.add("SE");
			directions.add("SSE");
			directions.add("SEE");
			directions.add("SO");
			directions.add("SSO");
			directions.add("SOO");
			
	
			for (String elem: forbiden) {
				int i = 0;
				while ( i < directions.size()) {
					if (directions.contains(elem)) {
						directions.removeIf(s -> s.contains(elem));
					} else {
						i++;
					}
				}
			}
			System.out.println("as direcoes permitidas sao apenas: " + directions);
			
			List<Integer> moves = new ArrayList<>();
			for (String x: directions) {
				int move = firstpoint;
				for (char d: x.toCharArray()) {
					if (d == 'N') {
						move = move - 3;
					} else if (d == 'S') {
						move = move + 3;
					} else if (d == 'E') {
						move = move + 1;
					} else if (d == 'O') {
						move = move - 1;
					}
				}
				if (!history.contains(move)) {
					moves.add(move);
				}
			}
			System.out.println("O array de movimentos possiveis: " + moves);
			
			return moves;
		}
	/**
	 * recursive method that locates the point, and along with the pattern length and
	 * the history, evaluates the possible ways a point can go.
	 * @param point   the initial point, it will be updated along the recursion
	 * @param length  the size of the pattern
	 * @param history list of all points already visited
	 * @return        the number of patterns (as Int)
	 */
	public int countPatternsAux(int point, int length, List<Integer> history) {
		if (length == 1) {
			return 1;
		}
		int patterns = 0;
		List<Integer> pWays = this.possibleWays(point, history);
		history.add(point);
		
		for (int nMove: pWays) {
			patterns += this.countPatternsAux(nMove, length-1, history);
		}
		
		return patterns;
		
	}
	
	//unused method
	public void pointLocation (List<Integer> history, int firstpoint, int length) {

		int row = 0, col = 0;
		// locate the first point in the matrix
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (patternMatrix[i][j] == firstpoint) {
					// identify the column and row in witch the element is
					row = i;
					col = j;
					System.out.println("the first point is in the row" + row + "and column" + col);
				}
			}
		}
		

	}
	
	
}

