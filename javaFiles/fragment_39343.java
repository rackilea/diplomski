public DateTime dateAndTimeToDateTime(java.sql.Date date, java.sql.Time time) {
    String myDate = date + " " + time;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    java.util.Date utilDate = new java.util.Date();
    try {
        utilDate = sdf.parse(myDate);
    } catch (ParseException pe){
        pe.printStackTrace();
    }
    DateTime dateTime = new DateTime(utilDate);

    return dateTime;
}