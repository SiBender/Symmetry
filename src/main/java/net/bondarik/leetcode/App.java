package net.bondarik.leetcode;

import net.bondarik.leetcode.geometry.Line;
import net.bondarik.leetcode.geometry.SymmetryFinder;

public class App {

    public static void main(String[] params) {
        double[] point3 = new double[]{6, 9};
        double[] point1 = new double[]{1, 4};
        double[] point2 = new double[]{3, 0};
        double[] point4 = new double[]{10, 1};
        double[] point5 = new double[]{1, 9};
        double[] point6 = new double[]{7, -3};

        double[][] points = new double[][]{point3, point1, point2, point4, point5, point6};

        SymmetryFinder sym = new SymmetryFinder();

        Line line = sym.getSymmetryLine(points);
        System.out.println(line);
    }
}
