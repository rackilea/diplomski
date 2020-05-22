public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    LocalDate parsed = LocalDate.parse("20151113", formatter);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(parsed, LocalTime.MIDNIGHT, ZoneId.of("Europe/Berlin"));
    // get OffsetDateTime similarly
}