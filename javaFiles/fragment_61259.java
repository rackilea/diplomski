Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.YEAR, 1975);
calendar.set(Calendar.MONTH, Calendar.JULY);
calendar.set(Calendar.DATE, 3);
SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
String result = df.format(calendar.getTime());
System.out.println("fmt: " + result);