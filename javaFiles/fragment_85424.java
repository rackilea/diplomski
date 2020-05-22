public static void main(String[] args) {
    /*
     * the base of this example is a date time with an offset of +01:00
     * (which is present in several zones, not just in Europe/Amsterdam!)
     */
    String datetime = "2019-11-28T12:49:24.000+01:00";
    // parse it to an offset-aware object
    OffsetDateTime plusOneHourOffsetDateTime = OffsetDateTime.parse(datetime);
    // print it to be sure ;-)
    System.out.println(plusOneHourOffsetDateTime
            .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    // convert it to a zone-aware date time object by providing the zone
    ZonedDateTime europeAmsterdamZonedDateTime = plusOneHourOffsetDateTime
            .atZoneSameInstant(ZoneId.of("Europe/Amsterdam"));
    // print it
    System.out.println(europeAmsterdamZonedDateTime
            .format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    // then take the same instant but use a different time zone
    ZonedDateTime utcZonedDateTime = plusOneHourOffsetDateTime
            .atZoneSameInstant(ZoneId.of("UTC"));
    // print that, it adds a Z (indicating an offset of 00:00) and the time zone
    // that was specified
    System.out.println(utcZonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    // take a totally different time zone and do it again
    ZonedDateTime pacificPalauZonedDateTime = plusOneHourOffsetDateTime
            .atZoneSameInstant(ZoneId.of("Pacific/Palau"));
    // print that one, too
    System.out.println(pacificPalauZonedDateTime
            .format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
}