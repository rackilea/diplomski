SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  Locale.ENGLISH);
     SimpleDateFormat outputFormat=   new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm  a");

    try {
        Date oneWayTripDate = inputFormat.parse(datedata);
    } catch (java.text.ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
String  datetime=    outputFormat.format(oneWayTripDate);
}