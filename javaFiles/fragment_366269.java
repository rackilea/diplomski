public static void main(String args[]) throws ParseException {
    final SimpleDateFormat format = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
    format.setLenient(false);
    format.parse("Sat, 16 Jan 2010 04:41:09 -0000");
}