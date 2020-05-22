public static Timestamp convertStringToTimestamp(String strRaw) throws ParseException
  {
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
   String dateInString = strRaw;
   Date date = formatter.parse(dateInString);
   TimeZone gmtTime = TimeZone.getTimeZone("GMT");
   formatter.setTimeZone(gmtTime);
   Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   calendar.setTime(date);
   SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

   Timestamp t = new Timestamp(formatter1.parse(formatter.format(calendar.getTime())).getTime());

   System.out.println("********"+new Date(t.getTime()));
   return new Timestamp(formatter1.parse(formatter.format(calendar.getTime())).getTime());

  }