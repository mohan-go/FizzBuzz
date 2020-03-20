package com.acme.util;

import com.acme.impl.NumberPrinterImpl;
import com.acme.util.exception.NumberPrinterException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class NumberPrinterTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void shouldReturnIntegerWhenBothPredicatesDoNotMatch() throws Exception {
		NumberPrinter printer = new NumberPrinterImpl("Fizz", "Buzz");
		String result = printer.printValue(4, e -> e % 3 == 0, e -> e % 5 == 0);
		assert(result.equals("4"));
	}

	@Test
	public void shouldReturnFirstStringWhenFirstPredicateMatches() throws NumberPrinterException {
		NumberPrinter printer = new NumberPrinterImpl("Fizz", "Buzz");
		String result = printer.printValue(4, e -> e % 4 == 0, e -> e % 5 == 0);
		assert(result.equals("Fizz"));
	}

	@Test
	public void shouldReturnSecondStringWhenSecondPredicateMatches() throws NumberPrinterException {
		NumberPrinter printer = new NumberPrinterImpl("Fizz", "Buzz");
		String result = printer.printValue(5, e -> e % 4 == 0, e -> e % 5 == 0);
		assert(result.equals("Buzz"));
	}

	@Test
	public void shouldReturnFirstAndSecondWhenBothMatch() throws Exception {
		NumberPrinter printer = new NumberPrinterImpl("Fizz", "Buzz");
		String result = printer.printValue(10, e -> e % 2 == 0, e -> e % 5 == 0);
		assert(result.equals("FizzBuzz"));
	}

	@Test
	public void shouldThrowExceptionWhenArgumentsAreNull() throws NumberPrinterException {
		try {
			NumberPrinter printer = new NumberPrinterImpl(null, "Buzz");
			String result = printer.printValue(5, e -> e % 5 == 0, e -> e % 5 == 0);
			fail("Exception expected not thrown");
		} catch (NumberPrinterException e) {
			assertTrue(e.getMessage().equals("strings cannot be null"));
		}
	}

	@Test
	public void shouldThrowExceptionWhenArgumentsAreNull_Integer() throws NumberPrinterException {
		try {
			NumberPrinter printer = new NumberPrinterImpl("test", "Buzz");
			String result = printer.printValue(null, e -> e % 5 == 0, e -> e % 5 == 0);
			fail("Exception expected not thrown");
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().equals("arguments cannot be null"));
		}
	}

	@Test
	public void shouldThrowExceptionWhenArgumentsAreNull_Predicate() throws NumberPrinterException {
		try {
			NumberPrinter printer = new NumberPrinterImpl("test", "Buzz");
			String result = printer.printValue(2, null, e -> e % 5 == 0);
			fail("Exception expected not thrown");
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().equals("arguments cannot be null"));
		}
	}
}