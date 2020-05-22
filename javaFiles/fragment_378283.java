Locale[] locales = Locale.getAvailableLocales();
Arrays.sort(locales, Comparator.comparing(Locale::toLanguageTag));
Map<String, List<String>> fmtLocales = new TreeMap<>();
for (Locale locale : locales) {
    String fmt = ((SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, locale)).toPattern();
    fmtLocales.computeIfAbsent(fmt, k -> new ArrayList<>()).add(locale.toLanguageTag());
}
fmtLocales.forEach((k, v) -> System.out.println(dateFormatToRegex(Locale.forLanguageTag(v.get(0))) + "   " + v));