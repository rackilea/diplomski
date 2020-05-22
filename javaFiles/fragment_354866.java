String  dateString="04/01/2014";
SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
try {
  Date date=format.parse(dateString);
  System.out.println(date);
} catch (ParseException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}