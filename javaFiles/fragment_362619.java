public int getThemeId(Context context) {
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
    String theme = settings.getString(context.getResources().getString(R.string.pref_theme_key), null);

    if (theme == null || theme.equals("THEME_LIGHT")) {
        return android.R.style.Theme_Holo_Light;
    } else if (theme.equals("THEME_DARK")) {
        return android.R.style.Theme_Holo;
    }

    // default
    return android.R.style.Theme_Holo_Light;
}