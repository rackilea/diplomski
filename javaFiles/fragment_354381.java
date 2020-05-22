String initialStringDate = "2019-01-27T09:27:37Z";
    Locale us = new Locale("US");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", us);
    try {
        Date date = format.parse(initialStringDate);
        String stringDate = new SimpleDateFormat("yyyy/MM/dd", us).format(date);
        String stringTime = new SimpleDateFormat("HH:mm", us).format(date);

        String finalDateTime = stringDate.concat(" ").concat(stringTime);

        Log.i("Date_and_Time", "" + finalDateTime);
    } catch (ParseException e) {
        e.printStackTrace();
    }