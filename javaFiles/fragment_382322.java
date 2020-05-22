String input_format = "EEE MMMMM dd HH:mm:ss Z yyyy";
    String input_value="Wed Jun 13 17:05:44 +0000 2012";
    Date date=null;

    SimpleDateFormat sdf = new SimpleDateFormat(input_format);
    try {
        date = sdf.parse(input_value);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    Calendar calendar = sdf.getCalendar();
    calendar.setTime(date);