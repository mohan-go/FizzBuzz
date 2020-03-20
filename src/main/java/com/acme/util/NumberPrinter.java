package com.acme.util;

import com.acme.util.exception.NumberPrinterException;

import java.util.function.Predicate;

public interface NumberPrinter {

    void printNumber(Integer upperLimit, Predicate<Integer> selectorOne, Predicate<Integer> selectorTwo) throws NumberPrinterException;
    String printValue(Integer value, Predicate<Integer> selectorOne, Predicate<Integer> selectorTwo) throws NumberPrinterException;
}
