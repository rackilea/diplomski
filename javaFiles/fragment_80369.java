try {
    String dateValue = "20 September, 2013";
    SimpleDateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
    Date date = df.parse(dateValue);
    System.out.println(date);
} catch (ParseException exp) {
    exp.printStackTrace();
}