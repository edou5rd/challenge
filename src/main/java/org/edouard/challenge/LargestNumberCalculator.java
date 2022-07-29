package org.edouard.challenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class LargestNumberCalculator {

    private LargestNumberCalculator() {
    }

    public static String getLargestNumber(final List<Integer> numbersList) {
        numbersList.sort(new Comparator<>() {
            @Override
            public int compare(final Integer x, final Integer y) {
                final Double xWithMask = x * Math.pow(10, getLength(y));
                final Double yWithMask = y * Math.pow(10, getLength(x));
                final Double xy = xWithMask + y;
                final Double yx = yWithMask + x;
                return xy.compareTo(yx);
            }

            private int getLength(int number) {
                int length;

                if (number == 0)
                    length = 1;
                else
                    length = 0;

                while (number > 0) {
                    length++;
                    number /= 10;
                }
                return length;
            }

        });
        Collections.reverse(numbersList);
        return LargestNumberListToString(numbersList);
    }

    private static String LargestNumberListToString(final List<Integer> numbersList) {
        final var stringBuilder = new StringBuilder();
        for (final int n : numbersList){
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }

}
