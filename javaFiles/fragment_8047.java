TimeZone timeZone = TimeZone.getTimeZone("UTC");
Calendar calendar = Calendar.getInstance(timeZone);
SimpleDateFormat simpleDateFormat = 
       new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
simpleDateFormat.setTimeZone(timeZone);

System.out.println("Time zone: " + timeZone.getID());
System.out.println("default time zone: " + TimeZone.getDefault().getID());
System.out.println();

System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
System.out.println("Default: " + calendar.getTime());