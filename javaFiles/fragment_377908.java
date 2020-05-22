String currentTime = "05/30/2018 16:56:21";
String endTime = "05/30/2018 16:59:21";
SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyyHH:mm:ss");

try {
    Date currentTimeDate = sdf.parse("05/30/2018 16:56:21");
    Date endTimeDate = sdf.parse("05/30/2018 16:59:21");
    currentTimeDate.compareTo(endTimeDate); // false / current time has not passed end time.
    endTimeDate.compareTo(currentTimeDate); // true / end time has passed current time.
} catch (ParseException ignored) {

}