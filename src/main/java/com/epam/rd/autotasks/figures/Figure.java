package com.epam.rd.autotasks.figures;

abstract class Figure {

    public double distance(Point p1, Point p2) {
        return Math.sqrt(StrictMath.pow(p2.getX() - p1.getX(), 2) + StrictMath.pow(p2.getY() - p1.getY(), 2));
    }

    public abstract Point centroid();

    public abstract boolean isTheSame(Figure figure);

    public boolean isDegenerativeTriangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) return true;
        if (a.getX() == a.getY() && b.getX() == b.getY() && c.getX() == c.getY()) return true;

        double d1 = distance(a, b);
        double d2 = distance(b, c);
        double d3 = distance(c, a);

        if ((d2 + d3) <= d1) return true;
        if ((d3 + d1) <= d2) return true;
        return (d1 + d2) <= d3;
    }

}
