String[] languages = Locale.getISOLanguages();
Map<String, Locale> localeMap = new HashMap<String, Locale>(languages.length);
for (String language : languages) {
    Locale locale = new Locale(language);
    localeMap.put(locale.getISO3Language(), locale);
}