/*
 * Copyright 2015-2022 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {
	Calculator calculator;

	@BeforeEach
	public void init() {
		this.calculator = new Calculator();
	}

	@Test
	@DisplayName("Add: 1 + 1 = 2")
	void addsTwoNumbers() {
		assertEquals(2, this.calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test
	@DisplayName("Subtract: 1 - 1 = 0")
	void subsTwoNumbers() {
		assertEquals(0, this.calculator.sub(1, 1), "1 - 1 should equal 0");
	}

	@Test
	@DisplayName("Multiply: 7 * 6 = 42")
	void mulTwoNumbers() {
		assertEquals(42, this.calculator.mul(7, 6), "7 * 6 should equal 42");
	}

	@Test
	@DisplayName("Divide: 42 / 7 = 6")
	void divideTwoNumbers() {
		assertEquals(6, this.calculator.div(42, 7), "42 / 7 should equal 6");
	}

	@ParameterizedTest(name = "Add: {0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void testAddition(int first, int second, int expectedResult) {
		assertEquals(expectedResult, this.calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "Subtract: {0} - {1} = {2}")
	@CsvSource({
			"0,    1,   -1",
			"1,    2,   -1",
			"49,  51, -2",
			"1,  100, -99"
	})
	void testSubtraction(int first, int second, int expectedResult) {
		assertEquals(expectedResult, this.calculator.sub(first, second),
				() -> first + " - " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "Multiply: {0} * {1} = {2}")
	@CsvSource({
			"0,    1,   0",
			"1,    2,   2",
			"49,  51, 2499",
			"1,  100, 100"
	})
	void testMultiplication(int first, int second, int expectedResult) {
		assertEquals(expectedResult, this.calculator.mul(first, second),
				() -> first + " * " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "Divide: {0} / {1} = {2}")
	@CsvSource({
			"1,    1,   1",
			"2,    1,   2",
			"2499, 49,  51",
			"100,  5, 20"
	})
	void testDivision(int first, int second, int expectedResult) {
		assertEquals(expectedResult, this.calculator.div(first, second),
				() -> first + " / " + second + " should equal " + expectedResult);
	}

	@Test
	@DisplayName("Divide by zero")
	void testDivideByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.div(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}
}
