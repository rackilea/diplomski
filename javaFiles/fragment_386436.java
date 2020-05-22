public class LanguageUtils {

/**
 * change language
 *
 * @param context
 * @param language
 */
public static void shiftLanguage(Activity context, String language) {
    if (language.equals("en")) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration config = context.getResources().getConfiguration();
        config.locale = Locale.ENGLISH;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        SharedPreferenceUtils.createSP(context, "en");
    } else {
        Locale.setDefault(Locale.CHINESE);
        Configuration config = context.getResources().getConfiguration();
        config.locale = Locale.CHINESE;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        SharedPreferenceUtils.createSP(context, "zh");
    }
    context.recreate();
}

/**
 * app start setting language
 *
 * @param context
 * @param language
 */
public static void startLanguage(Context context, String language) {
    if (language.equals("zh")) {
        Locale.setDefault(Locale.CHINESE);
        Configuration config = context.getResources().getConfiguration();
        config.locale = Locale.CHINESE;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    } else {
        Locale.setDefault(Locale.ENGLISH);
        Configuration config = context.getResources().getConfiguration();
        config.locale = Locale.ENGLISH;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}
}