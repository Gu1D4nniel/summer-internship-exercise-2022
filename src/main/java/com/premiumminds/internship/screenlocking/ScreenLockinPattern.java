package main.java.com.premiumminds.internship.screenlocking;

import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2022.
 */
class ScreenLockinPattern implements IScreenLockinPattern {

 /**
  * Method to count patterns from firstPoint with the length
  * @param firstPoint initial matrix position
  * @param length the number of points used in pattern
  * @return number of patterns
  */
  public Future<Integer> countPatternsFrom(int firstPoint,int length) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
	 * Integer value that represents the position of the first
	 * point in the Pattern.
	 * This value must not be less than 1 nor greater than 9
	 * @return number of the position
	 */
public int firstPoint() {
	// TODO Auto-generated method stub
	return 0;
}

	/**
	 * Integer value that represents the size of the Pattern
	 * This value must not be less than 1 nor greater than 9
	 * @return number of points to include
	 */
public int length() {
	// TODO Auto-generated method stub
	return 0;
};
}
