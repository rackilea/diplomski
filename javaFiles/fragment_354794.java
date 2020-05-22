public void incrementDate() {
    int dayLimit = 30;
    // month is zero-based index
    int monthLimit = 10;
    String startStringDate = "2017-11-16";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    Date startDate;
    java.sql.Date sqlDate;
    try {
        startDate = dateFormat.parse(startStringDate);
        calendar.setTime(startDate);
        while(calendar.get(Calendar.DAY_OF_MONTH) <= dayLimit && calendar.get(Calendar.MONTH) <= monthLimit) {
            sqlDate = new java.sql.Date(startDate.getTime());
            // here just use sqlDate in your prepared statement
            //...
            //e.g. preparedStatement.setDate(3, sqlDate);
            // ...
            System.out.println("Using sql date : " + sqlDate);
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, 1);
            startDate = calendar.getTime();
        }
    } catch (ParseException e) {
        e.printStackTrace();
    }
}