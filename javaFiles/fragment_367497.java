Control control = Control.getControl(Control.FORMAT_DEFAULT);
List<Locale> locales = control.getCandidateLocales("messages",
Locale.forLanguageTag("zh-HK"));
for (Locale locale : locales) {
    System.out.println(locale.toLanguageTag());
}