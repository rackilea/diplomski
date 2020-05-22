String strThatDay = "1985/08/25";
SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
Date d = null;
try {
 d = formatter.parse(strThatDay);//catch exception
} catch (ParseException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
} 


Calendar thatDay = Calendar.getInstance();
thatDay.setTime(d); //rest is the same....