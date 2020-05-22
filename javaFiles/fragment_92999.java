private static DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern("xxx");

public static String getSystemTimeOffset() {
    ZoneOffset offset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
    return offsetFormatter.format(offset);
}