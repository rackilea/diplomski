String date = "2015-03-02";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try {
    Date parsedDate = sdf.parse(date);
    System.out.println(sdf.format(parsedDate));
} catch (ParseException e) {
    e.printStackTrace();
}