Calendar startDate = new GregorianCalendar();
    startDate.set(Calendar.MINUTE, 0);
    startDate.set(Calendar.HOUR_OF_DAY, 0);
    startDate.add(Calendar.DAY_OF_MONTH, -1);
    String startTime = df.format(startDate.getTime());
    System.err.println(startTime);

    Calendar endDate = (Calendar) startDate.clone();
    endDate.add(Calendar.DAY_OF_MONTH, 1);
    String endTime = df.format(endDate.getTime());
    System.err.println(endTime);