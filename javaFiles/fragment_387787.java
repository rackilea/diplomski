SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");
    Date myDate = null;
    try {
        myDate = dateFormat.parse(dates);

    } catch (ParseException e) {
        e.printStackTrace();
    }

    SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
    String finalDate = timeFormat.format(myDate);