String hours = "05";
    String minutes = "45";
    String ampm = "PM";

    Calendar calendar = GregorianCalendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR, Integer.parseInt(hours));
    calendar.set(Calendar.MINUTE, Integer.parseInt(minutes));
    calendar.set(Calendar.AM_PM, "AM".equals(ampm) ? 0 : 1);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

    System.out.println(format.format(calendar.getTime()));