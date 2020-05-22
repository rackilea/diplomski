SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
        date = format.parse("2011-10-29");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.setTime(date);
    System.out.println("Day of the week = "
            + (calendar.get(Calendar.DAY_OF_WEEK)));
    System.out.println("Saturday? "
            + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY));

    try {
        date = format.parse("2011-10-29");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
    calendar.setTime(date);
    System.out.println("Day of the week = "
            + (calendar.get(Calendar.DAY_OF_WEEK)));
    System.out.println("Saturday? "
            + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY));