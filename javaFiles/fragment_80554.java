String startDateParser = "2018-04-19";
DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
Date finalStartDate = null;
try {
    finalStartDate = format.parse(startDateParser);
    System.out.println(finalStartDate);
} catch (ParseException ex) {
    System.out.println(ex.getMessage());
}