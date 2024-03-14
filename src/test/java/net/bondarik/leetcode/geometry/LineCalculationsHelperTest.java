package net.bondarik.leetcode.geometry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LineCalculationsHelperTest {

    @ParameterizedTest
    @MethodSource("getPointsWithExpectedA")
    void getA(double[] point1, double[] point2, double expected) {
        assertEquals(expected, LineCalculationsHelper.getA(point1,  point2));
    }

    @ParameterizedTest
    @MethodSource("getPointsWithExpectedB")
    void getB(double[] point1, double[] point2, double expected) {
        assertEquals(expected, LineCalculationsHelper.getB(point1,  point2));
    }

    @ParameterizedTest
    @MethodSource("getSymmetricalPointTestData")
    void getSymmetricalPoint(Line line, double[] point, double[] expected) {
        double[] actual = LineCalculationsHelper.getSymmetricalPoint(point, line);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    private static Stream<Arguments> getPointsWithExpectedA() {
        return Stream.of(
                Arguments.of(new double[]{0, 1}, new double[]{1, 0}, 1),
                Arguments.of(new double[]{0, 4}, new double[]{1, 3}, 1),
                Arguments.of(new double[]{3, 2}, new double[]{5, -2}, 1d / 2),
                Arguments.of(new double[]{0, -1}, new double[]{1, 0}, -1),
                Arguments.of(new double[]{-1, 1}, new double[]{1, 3}, -1),
                Arguments.of(new double[]{-1, -2}, new double[]{1, 4}, -1d / 3),
                Arguments.of(new double[]{1, 3}, new double[]{1, 1}, 0) //horizontal line
        );
    }

    private static Stream<Arguments> getPointsWithExpectedB() {
        return Stream.of(
                Arguments.of(new double[]{0, 1}, new double[]{1, 0}, 0),
                Arguments.of(new double[]{0, 4}, new double[]{1, 3}, 3),
                Arguments.of(new double[]{3, 2}, new double[]{5, -2}, -2),
                Arguments.of(new double[]{0, -1}, new double[]{1, 0}, 0),
                Arguments.of(new double[]{-1, 1}, new double[]{1, 3}, 2),
                Arguments.of(new double[]{-1, -2}, new double[]{1, 4}, 1),
                Arguments.of(new double[]{1, 3}, new double[]{1, 1}, 2) //horizontal line
                );
    }

    private static Stream<Arguments> getSymmetricalPointTestData() {
        return Stream.of(
                Arguments.of(new Line(1, 0), new double[]{0, 2}, new double[]{2, 0}),
                Arguments.of(new Line(1, 0), new double[]{-2, -1}, new double[]{-1, -2}),
                Arguments.of(new Line(-1, 2), new double[]{-2, 3}, new double[]{-1, 4}),
                Arguments.of(new Line(-1, 2), new double[]{1, -3}, new double[]{5, 1}),
                Arguments.of(new Line(1d/2, -2), new double[]{-1, -5}, new double[]{-3, -1}),
                Arguments.of(new Line(1d/2, -2), new double[]{9, 0}, new double[]{7, 4}),
                Arguments.of(new Line(-1d/3, 1), new double[]{-1, -2}, new double[]{1, 4}),
                Arguments.of(new Line(-1d/3, 1), new double[]{5, -4}, new double[]{7, 2}),
                Arguments.of(new Line(0, 1), new double[]{-5, 7}, new double[]{-5, -6}), //horizontal line
                Arguments.of(new Line(0, 1), new double[]{-5, 2}, new double[]{-5, 0}), //horizontal line
                Arguments.of(new Line(0, 10), new double[]{4, 15}, new double[]{4, 5}), //horizontal line
                Arguments.of(new Line(0, 10), new double[]{4, 5}, new double[]{4, 15}) //horizontal line
                );
    }
}