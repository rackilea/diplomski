public static void main(String[] args) throws Exception {

    SimpleDateFormat SDF_DATE_TIME_RECEIVED = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
    SDF_DATE_TIME_RECEIVED.setTimeZone(TimeZone.getTimeZone("IST"));

    SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd.MM.yyyyHH:mm:ss");
    originalDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

    String dateString = "02.04.201406:26:06";
    Date date1 = originalDateFormat.parse(dateString);
    String newDateString = SDF_DATE_TIME_RECEIVED.format(date1);

    System.out.println(newDateString);

    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    timeFormat.setTimeZone(TimeZone.getTimeZone("IST"));

    Date date2 = SDF_DATE_TIME_RECEIVED.parse(newDateString);
    String datePart = dateFormat.format(date2);
    String timePart = timeFormat.format(date2);

    System.out.println("datePart=" + datePart);
    System.out.println("timePart=" + timePart);
}