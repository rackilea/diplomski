public final class IsoUtil {
    private static final Set<String> ISO_LANGUAGES = new HashSet<String>
        (Arrays.asList(Locale.getISOLanguages()));
    private static final Set<String> ISO_COUNTRIES = new HashSet<String>
        (Arrays.asList(Locale.getISOCountries()));

    private IsoUtil() {}

    public static boolean isValidISOLanguage(String s) {
        return ISO_LANGUAGES.contains(s);
    }

    public static boolean isValidISOCountry(String s) {
        return ISO_COUNTRIES.contains(s);
    }
}