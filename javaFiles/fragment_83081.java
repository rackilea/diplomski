try {
    String startDateString = "08-12-2017";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(sdf2.format(sdf.parse(startDateString)));
} catch (ParseException e) {
    e.printStackTrace();
}