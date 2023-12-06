package com.epam.rd.autotasks.figures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Quadrilateral extends Figure {
    Point a, b, c, d;
    Point[] points;


    public Quadrilateral(Point a, Point b, Point c, Point d) {
        points = new Point[]{a, b, c, d};
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        if (a == null || b == null || c == null || d == null) throw new IllegalArgumentException();

        if (isDegenerativeTriangle(a, b, c)
                || isDegenerativeTriangle(b, c, d)
                || isDegenerativeTriangle(c, d, a)
                || isDegenerativeTriangle(d, a, b)) throw new IllegalArgumentException();


        if (! isConvex()) throw new IllegalArgumentException();

    }

    @Override
    public Point centroid() {
        Point center1 = centroidTriangle(a, b, c);
        Point center2 = centroidTriangle(a, c, d);
        Point center3 = centroidTriangle(a, d, b);
        Point center4 = centroidTriangle(b, d, c);
        return new Segment(center1, center2)
                .intersection(new Segment(center3, center4));
    }

    private Point centroidTriangle(Point a, Point b, Point c) {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;

        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {

        List<Point> pointList = List.of(points);
        List<Boolean> list = new ArrayList<>();

        int qax = (int) ((Quadrilateral) figure).a.getX();
        int qay = (int) ((Quadrilateral) figure).a.getY();
        int qbx = (int) ((Quadrilateral) figure).b.getX();
        int qby = (int) ((Quadrilateral) figure).b.getY();
        int qcx = (int) ((Quadrilateral) figure).c.getX();
        int qcy = (int) ((Quadrilateral) figure).c.getY();
        int qdx = (int) ((Quadrilateral) figure).d.getX();
        int qdy = (int) ((Quadrilateral) figure).d.getY();


        Point qa = new Point(qax, qay);
        Point qb = new Point(qbx, qby);
        Point qc = new Point(qcx, qcy);
        Point qd = new Point(qdx, qdy);


        if (pointList.contains(qa) && pointList.contains(qb) && pointList.contains(qc) && pointList.contains(qd))
            list.add(true);


        for (Boolean aBoolean : list) {
            if (aBoolean.equals(true)) return true;

        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Quadrilateral)) return false;
        Quadrilateral that = (Quadrilateral) o;
        return Objects.equals(a, that.a) && Objects.equals(b, that.b) && Objects.equals(c, that.c) && Objects.equals(d, that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Quadrilateral {" + " Point a:" + a + " Point b:" + b + " Point c:" + c + " Point d:" + d + "}";
    }


    public boolean isConvex() {
        boolean isNegative = false;
        boolean isPositive = false;
        int num_points = points.length;
        int B, C;
        for (int A = 0; A < num_points; A++) {
            B = (A + 1) % num_points;
            C = (B + 1) % num_points;

            double product =
                    prodLength(
                            points[A].getX(), points[A].getY(),
                            points[B].getX(), points[B].getY(),
                            points[C].getX(), points[C].getY());
            if (product < 0) {
                isNegative = true;
            } else if (product > 0) {
                isPositive = true;
            }
            if (isNegative && isPositive) return false;
        }
        return true;
    }

    public double prodLength(double aX, double aY, double bX, double bY, double cX, double cY) {
        double baX = aX - bX;
        double baY = aY - bY;
        double bcX = cX - bX;
        double bcY = cY - bY;

        return (baX * bcY - baY * bcX);
    }
}
