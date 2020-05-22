public static String getLabel(String resourceIndex, Locale locale) {
    ResourceBundle b1 = ResourceBundle.getBundle("uday.properties.Application", locale);
    if (b1.contains(resourceIndex)) {
       return b1.getString(resourceIndex);
    }
    ResourceBundle b2 = ResourceBundle.getBundle("uday.properties.Database", locale);
    return b2.getString(resourceIndex);
}