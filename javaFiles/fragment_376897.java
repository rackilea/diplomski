String dateString = "2010-11-22 08:08:08.123456";
    String fraction = dateString.substring(dateString.length() - 3);
    String formatString = dateString.substring(0, dateString.length() - 3);
    String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
    ParsePosition position = new ParsePosition(0);

    try
    {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);
        position.setIndex(0);
        Date date1 = format.parse(formatString, position);          
        System.out.println("Date 1: " + date1);
        System.out.println("Date 1 fraction: " + fraction);
        Date date2 = format.parse(formatString);
        System.out.println("Date 2: " + date2);
        System.out.println("Date 2 fraction: " + fraction);
    }
    catch (Exception e) // Should not happen
    {
        e.printStackTrace();
    }