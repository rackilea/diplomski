public static void main(String[] args) {
    // this is what you have, a datetime String with an offset
    String dateTime = "2008-01-10T11:00:00-05:00";
    // create a temporal object that considers offsets in time
    OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateTime);
    // just print them in two different formattings
    System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    System.out.println(offsetDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    // get the offset from the object
    ZoneOffset zonedOffset = offsetDateTime.getOffset();
    // get its display name (a String representation)
    String zoneOffsetString = zonedOffset.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
    // and print the result
    System.out.println("The offset you want to get is " + zoneOffsetString);
}