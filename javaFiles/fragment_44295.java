String test = "02/01/20";
String format = "dd/MM/yyyy";
SimpleDateFormat sdf = new SimpleDateFormat(format);
sdf.setLenient(false);
try {
    Date date = sdf.parse(test);
    if (!sdf.format(date).equals(test)) {
        throw new ParseException(test + " is not a valid format for " + format, 0);
    }
} catch (ParseException ex) {
    ex.printStackTrace();
}