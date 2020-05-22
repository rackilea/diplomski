DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
    String dateS = "1/1/1970 8:00 AM";
    format.setTimeZone(TimeZone.getTimeZone("UTC"));  
    format.setLenient(true);
    Date date = format.parse(dateS);
    System.out.println(date.getTime()); //<-- prints 28800000