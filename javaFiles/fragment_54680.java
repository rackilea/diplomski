Locale locale = ConfigurationCompat.getLocales(
                   Resources.getSystem().getConfiguration()).get(0);

String fmt = (locale == Locale.ENGLISH) ? "EEE MMM d" : "EEE d MMM";
String date = new SimpleDateFormat(fmt, locale)
                   .format(new java.util.Date(parseDt * 1000));