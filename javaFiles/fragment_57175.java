public class ShapeWithReference extends Rectangle {

private static final long serialVersionUID = 1L;

public ShapeWithReference(float x, float y, float width, float height) {
    super(x, y, width, height);
}

Object reference = new String("hello");