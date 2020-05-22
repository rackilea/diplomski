private List<DateFormat> acceptedFormats = Arrays.asList(
     new SimpleDateFormat("dd/MMM/yyyy"),
     new SimpleDateFormat("MMM/dd/yyyy"));

public List<DateFormat> getFirstFormatForDate(String date) {
    for ( DateFormat fmt : acceptedFormats ) {
        try {
            fmt.parse(date);
            return fmt;
        } catch (ParseException e) {
        }
    }
    return null;
}