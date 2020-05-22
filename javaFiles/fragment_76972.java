public static void main(String[] args) {
    // use your date here, this is just "now"
    Date date = new Date();
    // parse it to an object that is aware of the (currently wrong) time zone
    ZonedDateTime wrongZoneZdt = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("CET"));
    // print it to see the result
    System.out.println(wrongZoneZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

    // extract the information that should stay (only date and time, NOT zone or offset)
    LocalDateTime ldt = wrongZoneZdt.toLocalDateTime();
    // print it, too
    System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    // then take the object without zone information and simply add a zone
    ZonedDateTime correctZoneZdt = ldt.atZone(ZoneId.of("GMT"));
    // print the result
    System.out.println(correctZoneZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
}