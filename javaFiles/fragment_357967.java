public void attempt2(String baseName, final String extension) {
    ResourceBundle.Control control = new ResourceBundle.Control() {

      private String resourceFound = null;

      @Override
      public List<String> getFormats(String baseName) {
        return Arrays.asList(extension);
      }

      @Override
      public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        String resourceName = toResourceName(bundleName, format);

        if (loader.getResource(resourceName) != null) {
          resourceFound = resourceName;
          return new ResourceBundle() {

            @Override
            public Enumeration<String> getKeys() {
              return null;
            }

            @Override
            protected Object handleGetObject(String key) {
              return null;
            }

          };
        }
        return null;
      }

      @Override
      public String toString() {
        return resourceFound;
      }
    };

    ResourceBundle.getBundle(baseName, control);

    System.out.println("found #2: " + control.toString());
  }