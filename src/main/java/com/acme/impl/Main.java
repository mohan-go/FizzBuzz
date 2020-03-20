package com.acme.impl;

import com.acme.util.NumberPrinter;
import com.acme.util.exception.NumberPrinterException;

public class Main {
    public static void main(String [] args) throws NumberPrinterException {
    	oldRequirements();
    }

    private static void oldRequirements() throws NumberPrinterException {
		NumberPrinter printer = new NumberPrinterImpl("Fizz", "Buzz");
		printer.printNumber(10, e -> e % 3 == 0, e -> e % 5 == 0);
	}

    private static void newRequirements() throws NumberPrinterException {
		NumberPrinter printer = new NumberPrinterImpl("Fizz", "Buzz");
		printer.printNumber(10, e -> (e % 3 == 0 || e.toString().contains("3")), e -> (e % 5 == 0 || e.toString().contains("5")));
	}
}
