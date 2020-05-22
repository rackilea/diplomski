public static String addDay(int numberOfDays) {
    Date oldDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss", Locale.ENGLISH);
    Calendar c = Calendar.getInstance();
    c.setTime(oldDate);
    c.add(Calendar.DAY_OF_YEAR,numberOfDays);
    dateFormat=new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss",  Locale.ENGLISH);
    Date newDate=new Date(c.getTimeInMillis());
    String resultDate=dateFormat.format(newDate);
    return resultDate;
  }