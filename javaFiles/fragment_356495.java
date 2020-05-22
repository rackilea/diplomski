DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss Z");
  formatter.setTimeZone(TimeZone.getTimeZone("Europe/London"));
  System.out.println(formatter.format(date));

  formatter.setTimeZone(TimeZone.getTimeZone("Europe/Athens"));
  System.out.println(formatter.format(instance2.getTime()))