package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        if (isDegenerativeTriangle(a, b, c)) throw new IllegalArgumentException();

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;

        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return figure instanceof Triangle;

    }
}
