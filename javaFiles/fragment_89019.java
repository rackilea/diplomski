public static void main(String[] args) {
    DateTimeFormatter formatter = 
        new DateTimeFormatterBuilder().appendPattern("yyyyMMdd")
                                      .parseDefaulting(ChronoField.NANO_OF_DAY, 0)
                                      .toFormatter()
                                      .withZone(ZoneId.of("Europe/Berlin"));

    OffsetDateTime offsetDateTime = ZonedDateTime.parse("20151113", formatter).toOffsetDateTime();
    System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_DATE));
}