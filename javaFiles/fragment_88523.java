public abstract class Shape {
    public void accept(ShapeProcessor processor){
        processor.process(this);
    }
}

public interface ShapeProcessor {
    public void process(Shape shape);
    public void process(ColoredShape shape);
}

public class ShapeManager {
    private List<Shape> shapeList;

    public void processShapes(ShapeProcessor processor){
        for (Shape shape : shapeList){
            shape.accept(processor);
        }
    }
}