public static void main(String[] args) {
    String date = "March 27, 2009 00:00:00";
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss", Locale.ENGLISH)
                         .withZone(ZoneId.of("America/Los_Angeles"));
    long second = ZonedDateTime.parse(date, formatter).toEpochSecond();
    System.out.println(second); // prints "1238137200"
}