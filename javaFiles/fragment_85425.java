public static void main(String[] args) {
    // date time String without zone or offset information
    String dateTimeString = "2019-11-30T19:35:06";
    // create a LocalDateTime from the String
    LocalDateTime ldt = LocalDateTime.parse(dateTimeString);
    // then create a ZonedDateTime from the LocalDateTime adding a zone
    ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault()); // system default here
    // and print it
    System.out.println(zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
}