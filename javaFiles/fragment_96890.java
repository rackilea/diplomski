String langCode = null;

   Locale[] locales = Locale.getAvailableLocales();
   for (Locale localeIn : locales) {
          if (countryCode.equalsIgnoreCase(localeIn.getCountry())) {
                langCode = localeIn.getLanguage();
                break;
          }
    }