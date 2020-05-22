public ShapeType resolveShapeType(final List<Shape> shapes) {
    int sides = shapes.stream()
        .mapToInt(Shape::getSideCount)
        .filter(count -> count==4 || count==6)
        .max().orElse(0);
    return sides==6? ShapeType.HEXA: sides==4? ShapeType.RECT: ShapeType.GENERIC;
}