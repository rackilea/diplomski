for (Locale locale : Calendar.getAvailableLocales()) {
  if (locale.getCountry().length() > 0
      && Calendar.getInstance(locale) instanceof GregorianCalendar) {
    addItem(locale.getDisplayName());
  }
}