SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
String dateInString = "Wed Oct 16 00:00:00 CEST 2013";
    try {
        SimpleDateFormat parse = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
        Date date = parse.parse(dateInString);
        System.out.println(date);
        System.out.println(formatter.format(date));

    } catch (ParseException e) {
        e.printStackTrace();
    }