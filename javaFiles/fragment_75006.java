public static Locale parse(String locale) {
    final Matcher m = localePattern.matcher(locale);
    if (m.find()) {
        return new Locale.Builder()
                .setLanguage(m.group("lang"))
                .setScript(m.group("script"))
                .setRegion(m.group("region"))
                .setVariant(m.group("variant"))
                .build();
    } else throw new IllegalArgumentException(locale);
}