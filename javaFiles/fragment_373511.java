public static void main(String[] args) {
    // the source is just a time, but to correctly convert it, you need a date
    String utcTime = "12:15:00";
    // take today's date
    LocalDate today = LocalDate.now();
    // create a parseable date time String
    String parseableDateTime = today.format(DateTimeFormatter.ISO_DATE) + "T" + utcTime + "Z";
    // then create an Instant parsing the date time String
    Instant instant = Instant.parse(parseableDateTime);

    // get the ZoneId of UTC in order to have the time in UTC
    ZoneId utc = ZoneId.of("UTC");
    // do the same with your ZoneOffset of -4 Hours
    ZoneId gmtMinusFour = ZoneId.ofOffset("GMT", ZoneOffset.ofHours(-4));

    // create a UTC ZonedDateTime of the instant and the UTC ZoneID 
    ZonedDateTime utcZdt = ZonedDateTime.ofInstant(instant, utc);
    // then use that ZonedDateTime to convert it to a time with your ZoneId
    ZonedDateTime gmtMinusFourZdt = utcZdt.withZoneSameInstant(gmtMinusFour);

    // finally print both ZonedDateTimes in order to compare them
    System.out.println("UTC time is:\t\t" 
            + utcZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    System.out.println("GMT-4 time is:\t\t"
            + gmtMinusFourZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

    // then just get the time part of the converted ZonedDateTime
    LocalTime localTime = gmtMinusFourZdt.toLocalTime();
    // and print it
    System.out.println("Converted time is:\t" 
            + localTime.format(DateTimeFormatter.ISO_TIME));
}