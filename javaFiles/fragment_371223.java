@Override
protected void attachBaseContext(Context newBase) {

    Locale newLocale;
    // .. create or get your new Locale object here.

    Context context = ContextWrapper.wrap(newBase, newLocale);
    super.attachBaseContext(context);
}