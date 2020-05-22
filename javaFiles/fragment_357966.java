public void attempt1(String baseName, String extension) {
    List<String> locales = buildLocaleStrings(Locale.getDefault());
    String resourceFound = null;

    for (String locale : locales) {
      String resourceName = baseName + locale + "." + extension;
      URL resource = getClass().getClassLoader().getResource(resourceName);
      if (resource != null) {
        resourceFound = resourceName;
        break;
      }
    }
    System.out.println("found #1: " + resourceFound);
  }

  private List<String> buildLocaleStrings(Locale localeBase) {
    String locale = "_" + localeBase;
    List<String> locales = new ArrayList<String>();

    while (locale.length() > 0) {
      locales.add(locale);
      locale = locale.replaceFirst("_[^_]*?$", "");
    }
    locales.add("");

    return locales;
  }