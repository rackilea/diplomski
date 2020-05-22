/**
 * Format date with specified Date format
 * @param dateString
 * @param inFormat format of input date
 * @param outFormat format of result date
 * @return dateString
 */
public static String formatDate(String dateString, String inFormat, String outFormat){
    DateFormat inFormatter = new SimpleDateFormat(inFormat);
    inFormatter.setLenient(false);
    DateFormat outFormatter = new SimpleDateFormat(outFormat);

    Date date = null;
    try {
        date = inFormatter.parse(dateString);
    } catch (ParseException e) {
        e.printStackTrace();
        return "";
    }

    return outFormatter.format(date);
}