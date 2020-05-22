interface Shape {
    public abstract Intersection intersect(Shape other);

    public abstract Intersection doIntersect(Circle circle);

    public abstract Intersection doIntersect(LineSeg line);
}
class LineSeg implements Shape {
    @Override
    public Intersection intersect(Shape other) {
        return other.doIntersect(this);
    }

    Intersection doIntersect(Circle circle) {
        // Code to intersect with Circle
    }

    Intersection doIntersect(LineSeg other) {
       // Code to intersect with another Lineseg
    }
}

class Circle implements Shape {
    @Override
    public Intersection intersect(Shape other) {
        return other.doIntersect(this);
    }

    public Intersection doIntersect(Circle other) {
        // Code to intersect with another Circle
    }

    public Intersection doIntersect(LineSeg segment) {
        // Code to intersect with LineSeg
    }
}