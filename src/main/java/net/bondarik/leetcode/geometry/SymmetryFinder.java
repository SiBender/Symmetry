package net.bondarik.leetcode.geometry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SymmetryFinder {

    private Map<Double, Set<Double>> pointsMap = new HashMap<>();

    public Line getSymmetryLine(double[][] points) {
        init(points);

        int left = 0;
        int right = 1;

        while (right < points.length) {
            Line line = new Line(points[left], points[right]);

            if (isAllPointsSymmetrical(line, points)) {
                return line;
            }
            right++;
        }

        return null;
    }

    public Map<Double, Set<Double>> init(double[][] points) {
        for (double[] point : points) {
            Set<Double> pointsAtX = pointsMap.get(point[0]);
            if (pointsAtX == null) {
                pointsAtX = new HashSet<>();
                pointsMap.put(point[0], pointsAtX);
            }
            pointsAtX.add(point[1]);
        }

        return pointsMap;
    }

    private boolean isAllPointsSymmetrical(Line line, double[][] points) {
        for (double[] point : points) {
            double[] symmetricalPoint = LineCalculationsHelper.getSymmetricalPoint(point, line);
            if (!isPointExists(symmetricalPoint)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPointExists(double[] point) {
        Set<Double> yCoordinates = pointsMap.get(point[0]);
        return yCoordinates != null && yCoordinates.contains(point[1]);
    }
}
