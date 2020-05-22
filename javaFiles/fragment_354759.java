FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mmX");
try {
    Date fastDate = fastDateFormat.parse("2016-03-23T18:21+01:00");
    System.out.println(fastDate);
} catch (ParseException e) {
    LOG.error("Date time parsing exception", e);
}