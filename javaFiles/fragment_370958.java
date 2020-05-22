public LongStream allValuesAsLong() {
    return LongStream.concat(LongStream.concat(
      LongStream.range(2384, 2413).map(x -> x     <<32 | 3072),
      LongStream.range(3072, 3084).map(y -> 2413L <<32 | y)
    ),
    //...
      LongStream.range(2386, 2415).map(x -> x     <<32 | 3135)
    );
}
public List<Point> getRandomPoints(int num) {
    long count=allValuesAsLong().count();

    assert count > num;

    return new Random().longs(0, count)
        .distinct()
        .limit(num)
        .mapToObj(i -> allValuesAsLong().skip(i)
            .mapToObj(l -> new Point((int)(l>>>32), (int)(l&(1L<<32)-1)))
            .findFirst().get())
        .collect(Collectors.toList());
}