public class Shape {

    public boolean contains(Shape shape) {
        return false;
    }
}

public class NestedShape extends Shape {
    private List<Shape> subShapes = new ArrayList<Shape>();

    @Override
    public boolean contains(Shape shape) {
        if (subShapes.contains(shape)) {
            return true;
        }
        for (Shape subShape : subShapes) {
            if (subShape.contains(shape)) {
                return true;
            }
        }
        return false;
    }
}