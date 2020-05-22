private static final Pattern COMMA_PATTERN = Pattern.compile("\\s*,\\s*");

public List<Integer> getIntegerList() {
    // Assumes scanner is positioned at first integer in list.
    List<Integer> integers = new ArrayList<Integer>();
    for (;;) {
        integers.add(scanner.nextInt());
        if (scanner.hasNext(COMMA_PATTERN)) {
            // Read and discard comma token, and continue parsing list.
            scanner.next();
        } else {
            // Number is not followed by comma, stop parsing.
            break;
        }
    }
    return integers;
}