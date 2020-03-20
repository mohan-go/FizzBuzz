package com.acme.impl;

import com.acme.util.NumberPrinter;
import com.acme.util.exception.NumberPrinterException;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class NumberPrinterImpl implements NumberPrinter {

	private String stringOne;
	private String stringTwo;

	public NumberPrinterImpl(String stringOne, String stringTwo) throws NumberPrinterException {
		if(stringOne == null || stringTwo == null) {
			throw new NumberPrinterException("strings cannot be null");
		}
		this.stringOne = stringOne;
		this.stringTwo = stringTwo;
	}

	@Override
	public void printNumber(Integer upperLimit, Predicate<Integer> selectorOne, Predicate<Integer> selectorTwo) throws NumberPrinterException {
		if(upperLimit == null || selectorOne == null || selectorTwo == null) {
			throw new NumberPrinterException("arguments cannot be null");
		}
		IntStream.rangeClosed(1, upperLimit).forEach(
				nbr -> System.out.println(printValue(nbr, selectorOne, selectorTwo) )
		);
	}

	@Override
	public String printValue(Integer value, Predicate<Integer> selectorOne, Predicate<Integer> selectorTwo) throws RuntimeException {
		if(value == null || selectorOne == null || selectorTwo == null) {
			throw new RuntimeException("arguments cannot be null");
		}
		if(selectorOne.test(value) && selectorTwo.test(value)) {
			return stringOne + stringTwo;
		}
		if(selectorOne.test(value)) {
			return stringOne;
		}
		if(selectorTwo.test(value)) {
			return stringTwo;
		}
		return value.toString();
	}
}
