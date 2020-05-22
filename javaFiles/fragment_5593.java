public static void main(String[] args) throws Exception {
    String serverDate = "22.06.2018 16:00";
    String DATE_FORMAT = "dd.MM.yyyy HH:mm";
    String strDate;

    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
    Date gmt = sdf.parse(serverDate);

    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    strDate = sdf.format(gmt);
    System.out.println(strDate); // 22.06.2018 10:00
}