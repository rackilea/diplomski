SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.SSS");
try {
    Date date = formatter.parse(dateInString);
} catch (ParseException e) {
    e.printStackTrace();
}