public static  String endTime = "";
DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
Calendar cal = Calendar.getInstance();

cal.add(Calendar.MINUTE, 10)

endTime = timeFormat.format(cal.getTime());`