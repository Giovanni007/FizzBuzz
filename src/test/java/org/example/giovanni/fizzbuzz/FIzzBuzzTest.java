package org.example.giovanni.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FIzzBuzzTest {
	private final FizzBuzz fizzBuzz = new FizzBuzz();

	@ParameterizedTest
	@ValueSource(ints = { -1, 0 })
	void getFizzBuzzString_notPositiveInput_throwIllegalArgumentException(int x) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fizzBuzz.getFizzBuzzString(x, 4);
		});
	}

	@ParameterizedTest
	@CsvSource({ "1,1,1", "1,2,1 2",
			"1,20,1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz" })
	void getFizzBuzzString_validRange_returnfizzBuzzString(int x, int y, String expected) {
		assertEquals(fizzBuzz.getFizzBuzzString(x, y), expected);
	}

}
