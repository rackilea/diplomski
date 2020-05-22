private static Collection<Integer> ints() {
    Random random = new Random();
    return random.ints(100, 0, 100)
        .boxed()
        .collect(Collectors.toList());
}