TimeZone tz = TimeZone.getTimeZone("UTC");
Calendar c = Calendar.getInstance();
c.setTimeZone(tz);
c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) - 1);

DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
String nowAsISO = df.format(c.getTime());

System.out.println(nowAsISO);