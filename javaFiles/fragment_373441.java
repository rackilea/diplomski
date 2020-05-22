private static void createDate () throws Exception {
    String startConcat = startMonth + " " + startDate + " " + startTime;
    DateFormat formatter = new SimpleDateFormat ("MMM DD H");

    Date date = (Date) formatter.parse(startConcat);
    System.out.println(formatter.format(date));
}