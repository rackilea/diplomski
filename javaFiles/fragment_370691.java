public static String getDate() {
        Date myDate = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
       // new SimpleDateFormat("hh-mm-a").format(myDate);
        return date;
    }