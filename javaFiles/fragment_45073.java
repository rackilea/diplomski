private static Date cDate(String val, String... expectedFormat) {
    //Usage:  Date d = cDate("2016-06-22", "yyyy-MM-dd");

    String dFormat = "dd/MM/yyyy";
    if (expectedFormat.length != 0) { dFormat = expectedFormat[0]; }

    SimpleDateFormat formatter = new SimpleDateFormat(dFormat, Locale.ENGLISH);
    try { 
        Date bdate = formatter.parse(val);
        return bdate;   // Default format is 01/01/2015
    }
    catch (ParseException e) { return null; }
}