Date date = new Date();
SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d, yy hh:mm a", Locale.ENGLISH);
try {
    // m brings in all variables from a get/setter
    date = oldformat.parse(m.getEventTime());
} catch (ParseException e) {
    e.printStackTrace();
    Log.d("Response.Error.Date", m.getEventTime());
}
eventTime.setText(format.format(date));