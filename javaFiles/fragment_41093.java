int day = 11;
 int month = 2; // 0th January. 1st February... so on
 int year = 1997;

 Calendar calendar=Calendar.getInstance();
 calendar.set(Calendar.YEAR,year);
 calendar.set(Calendar.MONTH,month-1);
 calendar.set(Calendar.DATE,day);

 DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
 System.out.println(df.format(calendar.getTime()));