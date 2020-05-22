String str="Tue Oct 07 11:21:00 IST 2014";
Date date=new SimpleDateFormat("EEE MMM dd HH:mm:ssZ yyyy").parse(str);
System.out.println(date);
//now you can format this date to any format
//eg
DateFormat df=new SimpleDateFormat("MM/d/yy");
System.out.println(df.format(date));