public static void main(String[] args) throws Exception {
   String s = "01:19 PM";
   Date time = null;
   DateFormat parseFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
   System.out.println(time = parseFormat.parse(s));
  }