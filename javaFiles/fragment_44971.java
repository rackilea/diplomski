public ShapeType resolveShapeType(final List<Shape> shapes) {
    OptionalInt first = IntStream.range(0, shapes.size())
        .filter(index -> {
            int count = shapes.get(index).getSideCount();
            return count == 6 || count == 4;
        })
        .findFirst();
    if(!first.isPresent()) return ShapeType.GENERIC;
    int ix = first.getAsInt(), count = shapes.get(ix).getSideCount();
    return count==6? ShapeType.HEXA: shapes.subList(ix+1, shapes.size()).stream()
        .anyMatch(shape -> shape.getSideCount()==6)? ShapeType.HEXA: ShapeType.RECT;
}