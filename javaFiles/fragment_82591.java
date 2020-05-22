public static void main(String[] args) {
    Date date = new Date();
    DateFormat myDateFormat = new SimpleDateFormat();
    TimeZone firstTime = TimeZone.getTimeZone(args[0]);
    myDateFormat.setTimeZone(firstTime);
    System.out.println("-->"+args[0]+": " + myDateFormat.format(date));
}