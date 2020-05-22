DateFormat inputDF  = new SimpleDateFormat("MM/dd/yy");
Date date1 = inputDF.parse("9/30/11");

Calendar cal = Calendar.getInstance();
cal.setTime(date1);

int month = cal.get(Calendar.MONTH);
int day = cal.get(Calendar.DAY_OF_MONTH);
int year = cal.get(Calendar.YEAR);

System.out.println(month+" - "+day+" - "+year);