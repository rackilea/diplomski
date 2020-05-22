public static String convertTo24Hour(String Time) {
    DateFormat f1 = new SimpleDateFormat("hh:mm a"); //11:00 pm
    Date d = null;
    try {
        d = f1.parse(Time);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    DateFormat f2 = new SimpleDateFormat("HH:mm");
    String x = f2.format(d); // "23:00"

    return x;
}