public class ShapeManager<T extends Shape> {
    private List<T> shapeList;

    public void processShapes(ShapeProcessor processor){
        for (T shape : shapeList){
            processor.process(shape);
        }
    }
}