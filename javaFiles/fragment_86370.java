public static Date convertStringWithTimezoneToDate(String dateString) {
    if (dateString == null) {
        return null;
    }
    dateString += ":00";
    System.out.println(dateString);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    Date convertedDate = null;
    try {
        convertedDate = dateFormat.parse(dateString);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return convertedDate;
}