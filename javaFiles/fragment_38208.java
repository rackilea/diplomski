// this one took 612 ms to convert 12600 records   
Joda-Time library 2.3 version

private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("kk:mm");
private static DateTime dateTime = new DateTime();

public String getFormattedLabel(long timeStamp) {
    dateTime = dateTime.withMillis(timeStamp);
    return dateTime.toString(dateTimeFormatter);
}