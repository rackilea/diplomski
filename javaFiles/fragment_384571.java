String pattern = "MM/dd/yy 'US'"; // user-input
String text = "10/04/69 US"; // user-input
Locale locale = Locale.US; // user-input, too?

int yy = pattern.indexOf("yy");
DateTimeFormatter dtf;

if (
    (yy != -1) // explanation: condition ensures exactly two letters y
    && ((yy + 2 >= pattern.length()) || pattern.charAt(yy + 2) != 'y')
) {
    DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
    String part1 = pattern.substring(0, yy);
    if (!part1.isEmpty()) {
        builder.appendPattern(part1);
    }
    builder.appendValueReduced(ChronoField.YEAR, 2, 2, 1970);
    String part2 = pattern.substring(yy + 2);
    if (!part2.isEmpty()) {
        builder.appendPattern(part2);
    }
    dtf = builder.toFormatter(locale);
} else {
    dtf = DateTimeFormatter.ofPattern(pattern, locale);
}

LocalDate ld = LocalDate.parse(text, dtf);
System.out.println("user-date: " + ld); // 2069-10-04