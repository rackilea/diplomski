String hours = "05";
    String minutes = "45";
    String ampm = "PM";

    SimpleDateFormat format = new SimpleDateFormat("hh:mm a");

    Date dateTime = format.parse(String.format("%s:%s %s", hours, minutes, ampm));

    System.out.println(dateTime);