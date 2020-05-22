public class ResourceUtil {

    private static ResourceBundle rb;

    static {
        //set the default locale
        setLocale(Locale.ENGLISH);
    }

    public static void setLocale(Locale locale) {
        rb = ResourceBundle.getBundle("Resources", locale);
    }

    public static String tr(String key, Object... args) {
        return MessageFormat.format(rb.getString(key), args);
    }

}