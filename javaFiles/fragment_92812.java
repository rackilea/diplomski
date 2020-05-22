public class I18nHelper {
    public static I18nHelper get( HttpServletRequest request ) {
        return (HttpServletRequest) request.getAttribute( "I18nHelper" );
    }

    private Locale locale;

    public I18nHelper(Locale locale) {
        this.locale = locale;
    }

    public String msg1() {
        return Translator.get(locale, "MSG1");
    }
}