public static long getDateInMillis(String srcDate) {
    SimpleDateFormat desiredFormat = new SimpleDateFormat(
        "d MMMM yyyy, hh:mm aa");

    long dateInMillis = 0;
    try {
        Date date = desiredFormat.parse(srcDate);
        dateInMillis = date.getTime();
        return dateInMillis;
    } catch (ParseException e) {
        Log.d("Exception while parsing date. " + e.getMessage());
        e.printStackTrace();
    }

    return 0;
    }