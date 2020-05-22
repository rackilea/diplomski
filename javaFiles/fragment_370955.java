public List<Point> getRandomPoints(int num) {
    long count=allValues().count();

    assert count > num;

    return new Random().longs(0, count)
        .distinct()
        .limit(num)
        .mapToObj(i -> allValues().skip(i).findFirst().get())
        .collect(Collectors.toList());
}