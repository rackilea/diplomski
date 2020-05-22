public static String formatDateToMonthDay(Date date) {
    DateTimeFormattter monthDayFormatter = DateTimeFormatter.ofPattern("MMM-dd");
    Instant instant = date.toInstant();
    return instant.format(monthDayFormatter); 
}

public ObjectId getObjectId(String date, String fromTimeZone) {
    DateTimeFormattter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.parse(date,formatter);
    Instant instant = LocalDateTime.ofInstant(instant, ZoneId.of(fromTimeZone)).toInstant();
    return new ObjectId(Long.toHexString(instant.getEpochSecond()) + "0000000000000000");
}