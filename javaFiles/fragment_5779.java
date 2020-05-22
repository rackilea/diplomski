@NonNull Resources getLocalizedResources(Context context, Locale myLocale) {
    Configuration conf = context.getResources().getConfiguration();
    conf = new Configuration(conf);
    conf.setLocale(myLocale);
    Context localizedContext = context.createConfigurationContext(conf);
    return localizedContext.getResources();
}