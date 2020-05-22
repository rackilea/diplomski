Locale[] locales = Locale.getAvailableLocales();
            ArrayList<String> localcountries=new ArrayList<String>();
            for(Locale l:locales)
            {
                localcountries.add(l.getDisplayLanguage().toString());
            }
    String[] languages=(String[]) localcountries.toArray(new String[localcountries.size()]);