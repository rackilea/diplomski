SimpleDateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss zzzz yyyy");
    SimpleDateFormat df2 = new SimpleDateFormat("HH:mm a");

    Date convertedDate = new Date();
    try {
        convertedDate = df.parse(mEvent.getFromDate());
    } catch (ParseException ex) {
        //do nothing
    }
    startTime = df2.format(convertedDate);
    showFromTime.setText(startTime);