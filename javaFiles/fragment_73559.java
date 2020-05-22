public static <S extends Path> ArrayList<S> create_array(
    int X1, int Y1, int X2, int Y2,
    Function<PathElement[], S> shapeConstructor) {

    var shapes = new ArrayList<S>();
    shapes.add(shapeConstructor.apply(new PathElement[] {
        new MoveTo(X1, Y1), new LineTo(X2, Y2)
    }));
    //...
    return shapes;
}