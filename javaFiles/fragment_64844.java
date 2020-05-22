SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

Calendar calendar = Calendar.getInstance();

try {
    calendar.setTime(sdf.parse("2019-12-06T06:04:50.022461Z"));
} catch (Exception ex) {
    ex.printStackTrace();
}

SimpleDateFormat returnFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
returnFormat.format(calendar.getTime());