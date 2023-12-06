package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Point {
    public static final double DELTA = 0.0001;
    private final double x;
    private final double y;


    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "[" +
                "x=" + x +
                ", y=" + y +
                "]";
    }
}

