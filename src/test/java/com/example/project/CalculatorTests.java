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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test
	@DisplayName("1 - 1 = 0")
	void subsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.sub(1, 1), "1 - 1 should equal 0");
	}

	@Test
	@DisplayName("7 * 6 = 42")
	void mulTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(42, calculator.mul(7, 6), "7 * 6 should equal 42");
	}

	@Test
	@DisplayName("42 / 7 = 6")
	void divTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(6, calculator.div(42, 7), "42 / 7 should equal 6");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "{0} - {1} = {2}")
	@CsvSource({
			"0,    1,   -1",
			"1,    2,   -1",
			"49,  51, -2",
			"1,  100, -99"
	})
	void sub(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.sub(first, second),
				() -> first + " - " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({
			"0,    1,   0",
			"1,    2,   2",
			"49,  51, 2499",
			"1,  100, 100"
	})
	void mul(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.mul(first, second),
				() -> first + " * " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "{0} / {1} = {2}")
	@CsvSource({
			"1,    1,   1",
			"2,    1,   2",
			"2499, 49,  51",
			"100,  5, 20"
	})
	void div(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.div(first, second),
				() -> first + " / " + second + " should equal " + expectedResult);
	}
}
