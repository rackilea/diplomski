public static void printNWeeks(Calendar startDate, int weeks) {

    int firstDayOfWeek = startDate.getFirstDayOfWeek();
    int days = (startDate.get(Calendar.DAY_OF_WEEK) + 7 - firstDayOfWeek) % 7;
    startDate.add(Calendar.DATE, -days);

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    for (int i = 1; i <= weeks; i++) {

        startDate.add(Calendar.DATE, 7); // change to 7 to -7 for back dates

        Calendar endDate = Calendar.getInstance(Locale.US);
        endDate.setTime(startDate.getTime());
        endDate.add(Calendar.DATE, 6);          

        System.out.println(df.format(startDate.getTime()) + " - "
                + df.format(endDate.getTime()));
    }
}