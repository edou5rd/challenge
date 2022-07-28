package org.edouard.challenge.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class LargestNumberCalculator {

    private LargestNumberCalculator() {
    }

    public static String getLargestNumber(final List<Integer> numbersList) {
        final List<String> numbersStringsList = convertToStringList(numbersList);
        numbersStringsList.sort(new Comparator<>() {
            @Override
            public int compare(final String x, final String y) {
                final String xy = x + y;
                final String yx = y + x;
                return xy.compareTo(yx);
            }
        });
        Collections.reverse(numbersStringsList);
        return LargestNumberListToString(numbersStringsList);
    }

    private static List<String> convertToStringList(final List<Integer> numbersList) {
        final List<String> list = new ArrayList<>();
        for (final Integer i : numbersList){
            list.add(i.toString());
        }
        return list;
    }
    private static String LargestNumberListToString(final List<String> numbersList) {
        final var stringBuilder = new StringBuilder();
        for (final String n : numbersList){
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }

}
