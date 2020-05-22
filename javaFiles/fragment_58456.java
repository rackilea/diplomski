public static boolean isThisDateValid(String dateToValidate, String dateFormat) {
    if (dateToValidate == null) {
        return false;
    }

    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    sdf.setLenient(false);

    ParsePosition position = new ParsePosition(0);
    Date date = sdf.parse(dateToValidate, position);
    return date != null && position.getIndex() == dateToValidate.length();
}