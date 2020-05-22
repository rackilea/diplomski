public void populate(Bundle bundle) {
    String localisation = (String) bundle.getHeaders().get("Bundle-Localization");
    Locale locale = Locale.getDefault();

    populate(bundle.getEntry(getFileName(localisation)));
    populate(bundle.getEntry(getFileName(localisation, locale.getLanguage())));
    populate(bundle.getEntry(getFileName(localisation, locale.getLanguage(), locale.getCountry())));
    populate(bundle.getResource(getFileName("fragment")));
    populate(bundle.getResource(getFileName("fragment", locale.getLanguage())));
    populate(bundle.getResource(getFileName("fragment", locale.getLanguage(), locale.getCountry())));
}