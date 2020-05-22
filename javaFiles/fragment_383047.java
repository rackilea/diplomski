String dt = "01-JAN-2013";
DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

try {
     df.parse(dt);
     System.out.println("true");
} catch (ParseException e) {
     System.out.println("false");
}