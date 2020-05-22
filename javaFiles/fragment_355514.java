interface Shape {
    public void accept(ShapeVisitor v);
}

interface ShapeVisitor {
    public void visit(Circle c);
    public void visit(Square s);
    public void visit(Shape h);
}

class Circle implements Shape {
    double radius;
    public void accept(ShapeVisitor v) {
        v.visit(this);  // The correct overload is chosen at compile time
    }
}

class Square implements Shape {
    double edge;
    public void accept(ShapeVisitor v) {
        v.visit(this);  // The correct overload is chosen at compile time
    }
}

class AreaVisitor implements ShapeVisitor {
    double area;

    public void visit(Circle c) {
        area = Math.PI * c.radius * c.radius;
    }

    public void visit(Square s) {
        area = s.edge * s.edge;
    }

    public void visit(Shape h) {
        // A Shape implementation other than Square or Circle
        throw new RuntimeException(
                "I don't know how to compute the area of a " + h.getClass());
    }
}