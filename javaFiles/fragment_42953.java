DecimalFormat fm = new DecimalFormat("#.################");
  try {
   double x = fm.parse("1.12345678901234").doubleValue();
   System.out.println(x);
  } catch (ParseException e) {
   e.printStackTrace();
  }