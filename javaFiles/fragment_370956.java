public Stream<Point> allValues() {
    return Stream.concat(
        Stream.concat(
            IntStream.range(2384, 2413).mapToObj(x -> new Point(x, 3072)),
            IntStream.range(3072, 3084).mapToObj(y -> new Point(2413, y))
        ),
    //...
        IntStream.range(2386, 2415).mapToObj(x -> new Point(x, 3135))
    );
}