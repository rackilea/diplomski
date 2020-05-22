String a1="2003-08-15";
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
cal.setTime(sdf.parse(a1));
Date date=cal. getTime();
System.out.println(date);