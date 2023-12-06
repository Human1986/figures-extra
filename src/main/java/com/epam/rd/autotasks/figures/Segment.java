package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Segment {

    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if(Objects.isNull(start) || Objects.isNull(end) || start.equals(end))
            throw new RuntimeException();
        this.start = start;
        this.end = end;
    }

    Point intersection(Segment another) {
        double S1 = (end.getY() - start.getY()) / (end.getX() - start.getX());
        double S2 = (another.end.getY() - another.start.getY()) / (another.end.getX() - another.start.getX());
        if (S1 == S2) return null;

        double b1 = (start.getY() * end.getX() - end.getY() * start.getX()) / (end.getX() - start.getX());
        double b2 = (another.start.getY() * another.end.getX() - another.end.getY() * another.start.getX()) /
                (another.end.getX() - another.start.getX());

        double x = (b2 - b1) / (S1 - S2);
        double y = (S1 * b2 - S2 * b1) / (S1 - S2);

        if ((x > start.getX() && x > end.getX()) || (x > another.start.getX() && x > another.end.getX()) ||
                (x < start.getX() && x < end.getX()) || (x < another.start.getX() && x < another.end.getX()) ||
                (y > start.getY() && y > end.getY()) || (y > another.start.getY() && y > another.end.getY()) ||
                (y < start.getY() && y < end.getY()) || (y < another.start.getY() && y < another.end.getY()))
            return null;

        return new Point(x, y);

    }
}
