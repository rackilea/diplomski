String serverdateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  public String convertServerDateToUserTimeZone(String serverDate) {
    String ourdate;
    try {
        SimpleDateFormat formatter = new SimpleDateFormat(serverdateFormat, Locale.UK);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date value = formatter.parse(serverDate);
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(serverdateFormat, Locale.UK); //this format changeable
        dateFormatter.setTimeZone(timeZone);
        ourdate = dateFormatter.format(value);

        //Log.d("OurDate", OurDate);
    } catch (Exception e) {
        ourdate = "0000-00-00 00:00:00";
    }
    return ourdate;
}