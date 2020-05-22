/*
 * Converts a specified time to different time zones
 */
public void convert(Date dt) {
    // This prints: Date with default formatter: 2013-03-14 22:00:12 PDT
    // As my machine is in PDT time zone
    System.out.println("Date with default formatter: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(dt));

    // This prints: Date with IST time zone formatter: 2013-03-15 10:30:12 GMT+05:30
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    TimeZone tz = TimeZone.getTimeZone("GMT+0530");
    sdf.setTimeZone(tz);
    String dateIST = sdf.format(dt);
    System.out.println("Date with IST time zone formatter: " + dateIST);

    // This prints: Date CST time zone formatter: 2013-03-15 00:00:12 CDT        
    tz = TimeZone.getTimeZone("CST");
    sdf.setTimeZone(tz);
    System.out.println("Date CST time zone formatter: " + sdf.format(dt));
}