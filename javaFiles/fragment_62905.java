public static String nextString() {
    return IntStream.range(0, 10).boxed().map(i -> getRandomChar(i)).collect(Collectors.joining());
}

private static String getRandomChar(int i) {
    return String.valueOf((char)i);
}