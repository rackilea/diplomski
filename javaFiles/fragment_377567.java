String dubiousDate = "2014-04-01xyz";
DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date d;
try {
    d = sdf.parse(dubiousDate);
    System.out.println(dubiousDate + " -> " + d);
    // output: Tue Apr 01 00:00:00 CEST 2014
} catch (ParseException e) {
    e.printStackTrace();
    System.err.println(dubiousDate + " failed");
}