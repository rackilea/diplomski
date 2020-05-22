public static String getCurrentDateTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d = new Date();
    String datetime = sdf.format(d);
    return datetime;
}