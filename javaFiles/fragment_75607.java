private void setLocale(String lang, Context context) {
    Configuration config = context.getResources().getConfiguration();
    Locale locale = new Locale(lang);
    Locale.setDefault(locale);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        config.setLocale(locale);
        getApplicationContext().getResources().updateConfiguration(config, null);
    } else {
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, null);
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        config.setLocale(locale);
        config.setLayoutDirection(locale);
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        context.createConfigurationContext(config);
    } else {
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}