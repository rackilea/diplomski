private static final Predicate<String> IS_NOT_SPACES_ONLY = 
        Pattern.compile("^\\s*$").asPredicate().negate();

public static String implode(String delimiter, String... data) {
    return Arrays.stream(data)
            .filter(IS_NOT_SPACES_ONLY)
            .collect(Collectors.joining(delimiter));
}