public static long milisecondsFromDate(String dateStr) {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
        Date date = formatter.parse(dateStr);
        return date.getTime();
    } catch (Exception e) {
        Log.e("Tag", "Wrong date Format");
    }
    return -1;
}