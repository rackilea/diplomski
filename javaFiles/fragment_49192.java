final String stringDate = "2014-07-17 23:59";

    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date date = inputFormat.parse(stringDate);

    Calendar calendarDate = Calendar.getInstance();
    calendarDate.setTime(date);

    Calendar midnight = Calendar.getInstance();
    midnight.set(Calendar.HOUR_OF_DAY, 0);
    midnight.set(Calendar.MINUTE, 0);
    midnight.set(Calendar.SECOND, 0);
    midnight.set(Calendar.MILLISECOND, 0);

    if (calendarDate.compareTo(midnight) >= 0)
    {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        System.out.println(timeFormat.format(date));
    }
    else
    {
        SimpleDateFormat dateTimeForm = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println(dateTimeForm.format(date));
    }