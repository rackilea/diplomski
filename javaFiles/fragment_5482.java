String dateformat = "A valid date time format";
    String notValidDateFormat = "Not a valid date time format" ;
    final DateFormat fmt = new SimpleDateFormat("dd MMM yyyy hh:mm");
    Date input = null;
    try {
        input = fmt.parse(offerDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    if (input.before(new Date())) {
        return dateformat;
    }
    return notValidDateFormat;
}