Calendar systemCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
    Date date = (Date) formatter.parse("2015-02-03 10:11:12");
    System.out.println(date); // => Tue Feb 03 05:11:12 EST 2015
    System.out.println(formatter.format(date)); // => 2015-02-03 10:11:12