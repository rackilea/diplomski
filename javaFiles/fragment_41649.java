public static void main(String[] args) {
    // get a representation of a moment in time (not a specific date or time)
    Instant now = Instant.now();
    // then use that in order to represent it in a specific zone using an offset of -1 hour
    ZonedDateTime utcZdt = ZonedDateTime.ofInstant(now, ZoneOffset.ofHours(-1));
    // and use it again in order to have another one defined by a specific time zone
    ZonedDateTime laZdt = ZonedDateTime.ofInstant(now, ZoneId.of("America/Los_Angeles"));

    // and print the representation as String
    System.out.println(utcZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    System.out.println(laZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
}