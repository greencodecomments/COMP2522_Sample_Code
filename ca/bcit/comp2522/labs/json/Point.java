package ca.bcit.comp2522.labs.json;

import java.util.Objects;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int aX, int aY, int aZ) {
        x = aX;
        y = aY;
        z = aZ;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y &&
                z == point.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}

