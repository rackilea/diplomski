public static String convertFormat(String inputDate) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    Date date = null;
    try {
        date = simpleDateFormat.parse(inputDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }


    if (date == null) {
        return "";
    }

    SimpleDateFormat convetDateFormat = new SimpleDateFormat("hh:mm a");

    return convetDateFormat.format(date);
}