private static final Set<String> LANGUAGES = new HashSet<String>();
static {
    LANGUAGES.add("it");
    ... add the others ...
}

public static String getLocalLanguage() {
    String lang = Locale.getDefault().getCountry().toLowerCase();
    if (LANGUAGES.contains(lang)) {
        return lang;
    }
    return "it";
}