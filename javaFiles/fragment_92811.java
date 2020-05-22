public static String MSG1;

public static void setLocale(Locale locale) {
   MSG1 = Translator.get(locale, "MSG1");
}

static {
    setLocale( Locale.getDefault() );
}