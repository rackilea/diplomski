Calendar cal = new GregorianCalendar(2000, 0, 1);
    long testCalOne = cal.getTimeInMillis();
    cal.clear(Calendar.ZONE_OFFSET);
    cal.setTimeZone(TimeZone.getTimeZone("UTC"));
    long testCalTwo = cal.getTimeInMillis();

    Calendar cal2 = new GregorianCalendar(2000, 0, 1);
    cal2.setTimeZone(TimeZone.getTimeZone("UTC"));
    long testCalThree = cal2.getTimeInMillis();

    System.out.println(testCalOne + ", " + testCalTwo + ", " + testCalThree);