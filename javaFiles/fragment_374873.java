String date = "2015-04-12";
java.sql.Date dat = java.sql.Date.valueOf(date);
//create calander instance and get required params
Calendar cal = Calendar.getInstance();
cal.setTime(dat);
int month = cal.get(Calendar.MONTH);
int day = cal.get(Calendar.DAY_OF_MONTH);
int year = cal.get(Calendar.YEAR);