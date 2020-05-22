String dstr = ... // from date input field
String tstr = ... // from time input field

String pattern = "dd/MM/yyyy H:mm";
String dateTimeStr = dstr + " " + tstr;

SimpleDateFormat fmt = new SimpleDateFormat(pattern);
try {
    Date date = fmt.parse(dateTimeStr);
    long msecs = date.getTime();
} catch (ParseException ex) {
    // Handle parsing error here
}