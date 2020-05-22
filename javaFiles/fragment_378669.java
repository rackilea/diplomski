public static void displaySupportedLanguages(PrintStream out, Optional<String> tgtLang) {
  Translate translate = createTranslateService();
  LanguageListOption target = LanguageListOption.targetLanguage(tgtLang.orElse("en"));
  List<Language> languages = translate.listSupportedLanguages(target);

  for (Language language : languages) {
    out.printf("Name: %s, Code: %s\n", language.getName(), language.getCode());
  }
}