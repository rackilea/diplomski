private void setApplicationLanguage(String newLanguage) {
    Resources activityRes = getResources();
    Configuration activityConf = activityRes.getConfiguration();
    Locale newLocale = new Locale(newLanguage);
    activityConf.setLocale(newLocale);
    activityRes.updateConfiguration(activityConf, activityRes.getDisplayMetrics());

    Resources applicationRes = getApplicationContext().getResources();
    Configuration applicationConf = applicationRes.getConfiguration();
    applicationConf.setLocale(newLocale);
    applicationRes.updateConfiguration(applicationConf, 
    applicationRes.getDisplayMetrics());
}