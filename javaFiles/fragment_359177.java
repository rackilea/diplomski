public static ZonedDateTime parseNtp(String ts) {
    long seconds = Long.parseLong(ts.substring(0, 8), 16);
    long fraction = Long.parseLong(ts.substring(8), 16);
    return LocalDateTime.parse("1900-01-01T00:00:00").atZone(ZoneId.of("UTC"))
            .plusSeconds(seconds)
            .plusNanos((long)(1000000000.0 / (1L << 32) * fraction));
}