package net.bondarik.leetcode.geometry;

public class Line {
    // y = a * x + b;
    private double a;
    private double b;

    public Line(double[] point1, double[] point2) {
        this.a = LineCalculationsHelper.getA(point1, point2);
        this.b = LineCalculationsHelper.getB(point1, point2);
    }

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getY(double x) {
        return a * x + b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return String.format("y = %.2f * x + %.2f", getA(), getB());
    }
}
