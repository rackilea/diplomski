DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
try {
  Date date = formatter.parse("01/29/02");
} catch (ParseException e) {
  e.printStackTrace();
}