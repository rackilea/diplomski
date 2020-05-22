private static final Pattern COMMA_PATTERN = Pattern.compile("\\s*,\\s*");

public List<Integer> getIntegerList() {
    // Assumes scanner is positioned at first integer in list.
    List<Integer> integers = new ArrayList<Integer>();
    Pattern oldDelimiter = scanner.delimiter();
    scanner.useDelimiter(COMMA_PATTERN);
    while (scanner.hasNextInt()) {
        integers.add(scanner.nextInt());
    }
    // Reset delimiter
    scanner.useDelimiter(oldDelimiter);
    return integers;
}