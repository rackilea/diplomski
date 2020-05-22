public static void main(String[] args) {
    // this simulates the parameters passed to your method
    String offset = "+07:00";
    String date = "2019-11-05/16:00";
    // provide a pattern
    String formatPattern = "yyyy-MM-dd/HH:mm";
    // and create a formatter with it
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatPattern);
    // then parse the time to a local date using the formatter
    LocalDateTime ldt = LocalDateTime.parse(date, dtf);
    // create a moment in time at the UTC offset (that is just +00:00)
    Instant instant = Instant.ofEpochSecond(ldt.toEpochSecond(ZoneOffset.of("+00:00")));
    // and convert the time to one with the desired offset
    OffsetDateTime zdt = instant.atOffset(ZoneOffset.of(offset));
    // finally print it using your formatter
    System.out.println("UTC:\t" + ldt.format(dtf));
    System.out.println(zdt.getOffset().toString()
            + ": " + zdt.format(DateTimeFormatter.ofPattern(formatPattern)));
}