package org.edouard.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LargestNumberCalculatorTest {

    private static Stream<Arguments> shouldReturnExpectedOutputMethodSource() {
        return Stream.of(
                arguments("empty list", List.of(), ""),
                arguments("list with one number", List.of(5), "5"),
                arguments("list of 3 random numbers with a 0", List.of(12, 5, 0), "5120"),
                arguments("list of 3 random numbers", List.of(1,2,3), "321"),
                arguments("list of 2 random numbers", List.of(9,93), "993"),
                arguments("list of 4 random numbers", List.of(50,2,1,9), "95021"),
                arguments("example 1", List.of(5,50,56), "56550"),
                arguments("example 2", List.of(420,42,423), "42423420"),
                arguments("example 3", List.of(839,83), "83983"),
                arguments("List with max Integer", List.of(Integer.MAX_VALUE,83), "83" + Integer.MAX_VALUE),
                arguments("List with multiple values max Integer", List.of(Integer.MAX_VALUE, 99, Integer.MAX_VALUE,
                        Integer.MAX_VALUE, 12), "99" + Integer.MAX_VALUE  + Integer.MAX_VALUE + Integer.MAX_VALUE
                        + "12")
                );
    }

    @MethodSource("shouldReturnExpectedOutputMethodSource")
    @ParameterizedTest(name = "should_returnExpectedOutput - {0}")
    void should_returnExpectedOutput (final String testMessage, final List<Integer> numbers, final String expectedOutput){
        assertEquals(expectedOutput, LargestNumberCalculator.getLargestNumber(numbers));
    }

}