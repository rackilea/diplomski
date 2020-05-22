public static void main(final String[] args)
        throws UnsupportedEncodingException, ParseException {
    final String dateString = "2013-03-01";
    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    final Date date = formatter.parse(dateString);
    final Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.DAY_OF_MONTH, 1);
    System.out.println(formatter.format(c.getTime()));
}