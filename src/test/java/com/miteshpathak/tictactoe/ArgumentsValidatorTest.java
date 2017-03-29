package com.miteshpathak.tictactoe;

import org.junit.Test;

public class ArgumentsValidatorTest {

	public void testCheckInRangeValid() {
		ArgumentsValidator.checkInRange(5, 0, 10, "invalid if < 0 and > 10");
	}

	@Test(expected = RuntimeException.class)
	public void testCheckInRangeInvalid() {
		ArgumentsValidator.checkInRange(100, 0, 10, "invalid if < 0 and > 10");
	}

	@Test
	public void testCheckEqualsValid() {
		ArgumentsValidator.checkEquals("Hello World", "Hello World", "objects should be equal");
	}

	@Test(expected = RuntimeException.class)
	public void testCheckEqualsInvalid() {
		ArgumentsValidator.checkEquals("Hello World", "Blow World", "objects should be equal");
	}

	@Test
	public void testCheckStringValidity() {
		ArgumentsValidator.checkValidString("MyLengthIsLessThan20", 20, "Lenght should be less than 20");
	}

	@Test(expected = RuntimeException.class)
	public void testCheckInvalidString() {
		ArgumentsValidator.checkValidString("My Length Is More Than 20", 20, "Lenght should be less than 20");
	}
}
