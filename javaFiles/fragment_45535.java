public static void main(String[] args) {
    // this simulates the parameters passed to your method
    String offset = "+07:00";
    String date = "2019-11-05/23:00";

    // create a LocalDateTime using the date time passed as parameter
    LocalDateTime ldt = LocalDateTime.parse(date,
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm"));
    // parse the offset
    ZoneOffset zoneOffset = ZoneOffset.of(offset);
    // create an OffsetDateTime using the parsed offset
    OffsetDateTime odt = OffsetDateTime.of(ldt, zoneOffset);
    // print the date time with the parsed offset
    System.out.println(zoneOffset.toString()
            + ":\t" + odt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    // create a ZonedDateTime from the OffsetDateTime and use UTC as time zone
    ZonedDateTime utcZdt = odt.atZoneSameInstant(ZoneOffset.UTC);
    // print the date time in UTC using the ISO ZONED DATE TIME format
    System.out.println("UTC:\t"
            + utcZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    // and then print it again using your desired format
    System.out.println("UTC:\t"
            + utcZdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm")));
}