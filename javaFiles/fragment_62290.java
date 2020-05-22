private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

public static String getNewDate(String sdate, int days) throws Exception {
    Date inputDate = dateFormat.parse(sdate);

    Calendar calendar = new GregorianCalendar();
    calendar.setTime(inputDate);
    calendar.add(Calendar.DAY_OF_MONTH, days);

    return dateFormat.format(calendar.getTime());
}

public static void main(String[] args) throws Exception {
    System.out.println(getNewDate("2011-07-11", -1));
    System.out.println(getNewDate("2011-07-11", 1));
}