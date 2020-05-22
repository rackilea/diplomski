public static boolean areAllNull(Object... objects) {
     return Stream.of(objects).allMatch(Objects::isNull);
}

public static boolean areAllNotNull(Object... objects) {
     return Stream.of(objects).allMatch(Objects::nonNull);
}