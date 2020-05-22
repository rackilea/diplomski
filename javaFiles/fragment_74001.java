static Date parseDate(String in) throws ParseException {
  return new SimpleDateFormat(in.contains(".")? "dd.MM.yyyy" : "MM/dd/yyyy")
    .parse(in);
}
public static void main(String[] args) throws Exception {
  System.out.println(parseDate("31.01.2001"));
  System.out.println(parseDate("01/31/2001"));
}