SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
try {
  sdf.setLenient(false);
  System.out.println(sdf.parse("2012/12/15")); 
} catch(ParseException e) {
  e.printStackTrace();
}