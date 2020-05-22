public static boolean usesAmPm(Locale locale) {
  DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL, locale);
  if (df instanceof SimpleDateFormat) {
    return ((SimpleDateFormat) df).toPattern().contains("a");
  } else {
    return false; // unlikely to happen
  }
}