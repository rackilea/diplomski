String time = "16:00";
String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
try {
    Date timeAt = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date + " " + time);
    System.out.println(timeAt);
} catch (ParseException ex) {
    ex.printStackTrace();
}