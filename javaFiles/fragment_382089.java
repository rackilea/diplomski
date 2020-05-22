String time = "16:00";
try {
    Date timeAt = new SimpleDateFormat("HH:mm").parse(time);
    System.out.println(timeAt);
} catch (ParseException ex) {
    ex.printStackTrace();
}