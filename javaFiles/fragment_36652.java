Instant[] instants = new Instant[] {
        LocalDateTime.of(1939, 6, 1, 0, 0).toInstant(ZoneOffset.UTC),
        LocalDateTime.of(1940, 6, 1, 0, 0).toInstant(ZoneOffset.UTC),
        LocalDateTime.of(1947, 6, 1, 0, 0).toInstant(ZoneOffset.UTC),
        Instant.ofEpochSecond(0), // 1970-01-01T00:00:00 UTC
        LocalDateTime.of(1970, 6, 1, 0, 0).toInstant(ZoneOffset.UTC),
        Instant.now().truncatedTo(ChronoUnit.DAYS), // 2015-08-31T00:00:00 UTC
};

for (Instant instant : instants) {
    LocalDateTime inBerlin = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Berlin"));
    System.out.println("UTC    " + instant.atOffset(ZoneOffset.UTC).toLocalDateTime());
    System.out.println("BERLIN " + inBerlin);
    System.out.println();
}