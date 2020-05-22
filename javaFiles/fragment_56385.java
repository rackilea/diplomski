SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    Calendar cal = Calendar.getInstance();
    cal.setTimeZone(TimeZone.getTimeZone("GMT"));
    cal.set(1900, 0, 1, 0, 0, 0);
    System.out.println(df.format(cal.getTime()));
    cal.setTimeInMillis(cal.getTimeInMillis() + 1000 * 60 * 60 * 24);
    System.out.println(df.format(cal.getTime()));