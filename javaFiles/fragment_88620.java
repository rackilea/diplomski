SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
try {
    Date parsedDate1 = formatter.parse("14-08-2017");
    System.out.println(parsedDate1);

    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
    Date parsedDate2 = formatter2.parse("2017-08-1 00:00:00.0 +0:00");
    Assert.assertEquals(parsedDate1, parsedDate2);

} catch (ParseException e1) {
}