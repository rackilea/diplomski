String in = "2015-11-21T17:49:49+0000";
String fmtIn = "yyyy-MM-dd'T'HH:mm:ssZ";
String fmtOut = "EEE MMM dd HH:mm:ss Z yyyy";
DateFormat sdf = new SimpleDateFormat(fmtIn);
try {
    Date d = sdf.parse(in);
    DateFormat outSDF = new SimpleDateFormat(fmtOut);
    System.out.println(outSDF.format(d));
} catch (ParseException e) {
    e.printStackTrace();
}