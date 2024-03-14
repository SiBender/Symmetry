package net.bondarik.leetcode.geometry;

public class LineCalculationsHelper {

    public static double getA(double[] point1, double[] point2) {
        if (point1[1] == point2[1]) {
            return Double.MAX_VALUE;
        }

        if (point1[0] == point2[0]) {
            return 0;
        }

        return -1d * (point1[0] - point2[0]) / (point1[1] - point2[1]);
    }

    public static double getB(double[] point1, double[] point2) {
        double a = getA(point1, point2) * (point1[0] + point2[0]);
        if (a == Double.MAX_VALUE) {
            return (point1[1] + point2[1]) / 2d;
        }
        return (point1[1] + point2[1]) / 2d - a / 2d;
    }

    public static double[] getSymmetricalPoint(double[] point, Line line) {
        double delta = point[1] - line.getY(point[0]);
        double symmetryA = -1D / line.getA();
        double symmetyB = point[1] - symmetryA * point[0];

        double symmetryX = (symmetyB - line.getB() + delta) / (line.getA() - symmetryA);
        double symmetryY = line.getY(symmetryX) - delta;
        return new double[]{symmetryX, symmetryY};
    }
}
