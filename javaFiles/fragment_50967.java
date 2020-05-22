private static final String COPYRIGHT_PROPERTY  = "%YEAR% copyright-message";
private static final String SHOWYEAR            = 
        "" + Calendar.getInstance().get(Calendar.YEAR);

public String getCopyrightProperty() {
    String s = this.properties.get(COPYRIGHT_PROPERTY, "");
    if (s == null) {
        return null;
    } else {
        return getSubstituteCurrYear(s);
    }
}

public String getSubstituteCurrYear(String in) {
    return in.replaceAll("%YEAR%", SHOWYEAR);
}