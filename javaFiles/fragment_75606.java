@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String localLanguage = MySingleton.getmInstance(this).getAppLang();
    if (localLanguage.equals(getString(R.string.settings_language_arabic_value))) {
        setLocale("ar", this);
    } else if (localLanguage.equals(getString(R.string.settings_language_english_value))) {
        Locale localeEn = new Locale("en");
        setLocale("en", this);
    }
    setContentView(R.layout.activity_branches);
    .........
    .........
}