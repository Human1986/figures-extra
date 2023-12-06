package com.epam.rd.autotasks.figures;

class Circle extends Figure {

    public static final double DELTA = 0.0001;
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0 || center == null) throw new IllegalArgumentException();
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle) {

            Circle circle = (Circle) figure;

            double cx = Math.round(center.getX());
            double cy = Math.round(center.getY());

            double fx = figure.centroid().getX();
            double fy = figure.centroid().getY();

            double radiusC = Math.round(this.radius);
            double radiusF = circle.radius;

            return cx == fx && cy == fy && radiusC == radiusF;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center = " + center +
                ", radius =" + radius +
                '}';
    }
}
