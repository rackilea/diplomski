DateFormat formatter = new SimpleDateFormat("MM/dd");
    Calendar cal = Calendar.getInstance();
    String calAsString = formatter.format(cal.getTime());
    System.out.println(calAsString);

    // Now for tomorrow's date:
    int offset = 1;
    cal.add(Calendar.DATE, offset);
    calAsString = formatter.format(cal.getTime());
    System.out.println(calAsString);