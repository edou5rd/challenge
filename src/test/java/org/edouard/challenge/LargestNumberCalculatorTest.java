package org.edouard.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class LargestNumberCalculatorTest {

    private static Stream<Arguments> shouldReturnExpectedOutputMethodSource() {
        final List<Integer> list1 = new  ArrayList<>();
        final List<Integer> list2 = Arrays.asList(5);
        final List<Integer> list3 = Arrays.asList(12, 5, 0);
        final List<Integer> list4 = Arrays.asList(1,2,3);
        final List<Integer> list5 = Arrays.asList(9,93);
        final List<Integer> list6 = Arrays.asList(50,2,1,9);
        final List<Integer> list7 = Arrays.asList(5,50,56);
        final List<Integer> list8 = Arrays.asList(420,42,423);
        final List<Integer> list9 = Arrays.asList(839,83);
        final List<Integer> list10 = Arrays.asList(Integer.MAX_VALUE,83);
        final List<Integer> list11 = Arrays.asList(Integer.MAX_VALUE, 99, Integer.MAX_VALUE, Integer.MAX_VALUE, 12);
        final List<Integer> list12 = Arrays.asList(Integer.MAX_VALUE, (Integer.MAX_VALUE -1), 99);
        final List<Integer> list13 = Arrays.asList(0, 99, 0);

        return Stream.of(
                arguments("empty list", list1, ""),
                arguments("list with one number", list2, "5"),
                arguments("list of 3 random numbers with a 0", list3, "5120"),
                arguments("list of 3 random numbers", list4, "321"),
                arguments("list of 2 random numbers", list5, "993"),
                arguments("list of 4 random numbers", list6, "95021"),
                arguments("example 1", list7, "56550"),
                arguments("example 2", list8, "42423420"),
                arguments("example 3", list9, "83983"),
                arguments("List with max Integer", list10, "83" + Integer.MAX_VALUE),
                arguments("List with multiple values max Integer", list11,
                        "99" + Integer.MAX_VALUE  + Integer.MAX_VALUE + Integer.MAX_VALUE + "12"),
                arguments("test precision.", list12, "99" + Integer.MAX_VALUE  + (Integer.MAX_VALUE -1)),
                arguments("multiple null values .", list13, "9900")
                );
    }

    @MethodSource("shouldReturnExpectedOutputMethodSource")
    @ParameterizedTest(name = "should_returnExpectedOutput - {0}")
    void should_returnExpectedOutput (final String testMessage,
                                      List<Integer> numbers,
                                      final String expectedOutput){
        assertEquals(expectedOutput, LargestNumberCalculator.getLargestNumber(numbers), testMessage);
    }

}