private static final Pattern PATTERN = Pattern.compile("^(\\d+): \\w+$");

// ...

public String extractNumber(String toMatch) {
    Matcher m = PATTERN.matcher(toMatch);
    return m.find() ? m.group(1) : null;
}