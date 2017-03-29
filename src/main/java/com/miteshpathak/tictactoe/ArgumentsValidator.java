package com.miteshpathak.tictactoe;

/**
 * Utility class to validate arguments.
 * Throws {@link RuntimeException} if argument validation fails
 * 
 * @author Mitesh Pathak <miteshpathak05@gmail.com>
 */
public class ArgumentsValidator {

	public static void checkInRange(int num, int min, int max, String message) {
		if (num < min || num > max) {
			throw new RuntimeException(message);
		}
	}

	public static void checkValidString(String str, int maxAllowedSize, String message) {
		if (str == null || str.length() > maxAllowedSize) {
			throw new RuntimeException(message);
		}
	}

	public static void checkEquals(Object obj1, Object obj2, String message) {
		boolean isEqual = obj1 != null && obj1.equals(obj2);
		if (!isEqual) {
			throw new RuntimeException(message);
		}
	}
}
