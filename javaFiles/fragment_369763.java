public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    Long timestamp = Long.parseLong("1418056895"); //Long.parseLong(feedObj.getString("date"));
    cal.setTimeInMillis(timestamp * 1000L);
    DateFormat format = new SimpleDateFormat("MM/dd/yyyy"); // what ever format you need.
    System.out.println(format.format(cal.getTime())); // this will be in MM/dd/yyyy
    //item.setTimeStamp(format.format(cal.getTime()));
}