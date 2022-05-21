package main.java.com.premiumminds.internship.screenlocking;

import java.util.concurrent.Future;

/**
  * Created by aamado on 05-05-2022.
  * Edited by Gu1D4nniel on 21-05-2022.
  */
interface IScreenLockinPattern {
	/**
	 * Integer value that represents the position of the first
	 * point in the Pattern.
	 * @return number of the position
	 */
	int firstPoint();
	
	/**
	 * Integer value that represents the size of the Pattern
	 * @return number of points to include
	 */
	int length();
  /**
    * Method to count patterns from firstPoint with the length
    * @param firstPoint initial matrix position
    * @param length the number of points used in pattern
    * @return number of patterns
    */
  public Future<Integer> countPatternsFrom(int firstPoint,int length);
}
