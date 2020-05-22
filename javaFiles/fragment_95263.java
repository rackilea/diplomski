//Get this one provided by dependency injection for example
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
    String dateString = sdf.format(new Date());
    Date date = sdf.parse(dateString);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);