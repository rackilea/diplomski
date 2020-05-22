String dateStr = "Jul 27, 2011 8:35:29 AM";
DateFormat readFormat = new SimpleDateFormat( "MMM dd, yyyy hh:mm:ss aa");
DateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
Date date = null;
try {
    date = readFormat.parse(dateStr);
} catch (ParseException e) {
    e.printStackTrace();
}

if (date != null) {
    String formattedDate = writeFormat.format(date);
}