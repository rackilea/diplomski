Calendar c = Calendar.getInstance();
c.setTime(new Date(yourmilliseconds));
c.set(Calendar.MILLISECOND, 0);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm.ss.SSS'Z'");
sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println(sdf.format(c.getTime()));