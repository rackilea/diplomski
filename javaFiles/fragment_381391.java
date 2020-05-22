public class ThemeManager {

    public static void applyCustomTheme(Context context, int styleResId) {
        context.getTheme().applyStyle(styleResId, true);
    }

}