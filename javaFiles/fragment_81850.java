private static String formatVolumeForLife(String rateBasisValue, String volumeValue) {
    NumberFormat formatter;
    if(PER_UNIT.equals(rateBasisValue) || PER_DEPENDENT_PER_UNIT_PER_MONTH.equals(rateBasisValue)){
        formatter = new DecimalFormat(FORMAT_NUMBER_WITH_COMMA);
    } else {
        formatter = new DecimalFormat(FORMAT_CURRENCY);
    }
    return formatter.format(Double.parseDouble(volumeValue));
}