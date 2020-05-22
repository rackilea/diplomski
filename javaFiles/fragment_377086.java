DateTime dt = new DateTime(1385577373517L, DateTimeZone.UTC);
    // Prints 2013-11-27T18:36:13.517Z
    System.out.println(dt);

    // Prints 2013-11-27T18:36:00.000Z (Floor rounded to a minute)
    System.out.println(dt.minuteOfDay().roundFloorCopy());

    // Prints 2013-11-27T18:30:00.000Z (Rounded to custom minute Window)
    int windowMinutes = 10;
    System.out.println(
        dt.withMinuteOfHour((dt.getMinuteOfHour() / windowMinutes) * windowMinutes).minuteOfDay().roundFloorCopy()
    );        

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("m");
    String minute = DATE_FORMAT.format(dt.toDate());

    String minString = "" + ((int)Math.round(Integer.parseInt(minute)/10)) * 10;

    System.out.println("Result: " +  minString);