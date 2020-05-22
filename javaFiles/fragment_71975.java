Locale locale = new Locale("en");
Locale.setDefault(locale);
Configuration config = new Configuration();
config.locale = locale;
getBaseContext().getResources().updateConfiguration(config,
      getBaseContext().getResources().getDisplayMetrics());