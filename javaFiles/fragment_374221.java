private static void isContains(String[] coordinates) {
    boolean contains = Arrays.stream(coordinates)
            .anyMatch(coordinate -> coordinate.contains("s") || coordinate.contains("n"));
    if (contains) {
        System.out.println("It works!");
    } else {
        System.out.println("RAKAMAKAFO");
    }
}