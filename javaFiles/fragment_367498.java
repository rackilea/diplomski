Control control = Control.getControl(Control.FORMAT_DEFAULT);
List<Locale> locales = control.getCandidateLocales("messages",
Locale.forLanguageTag("pl-PL"));
for (Locale locale : locales) {
    String bundleName = control.toBundleName("messages", locale);
    System.out.println(bundleName);
    String resourceName = control.toResourceName(bundleName, "properties");
    System.out.println(resourceName);
}