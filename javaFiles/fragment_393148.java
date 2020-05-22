Calendar TodayDate = Calendar.getInstance();
TodayDate.add(Calendar.DAY_ON_MONTH, -1);//import java.util.*
Date yesterday = cal.getTime();
SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
String Format = format.format(yesterday);
System.out.println(Format);// 01/06/2016