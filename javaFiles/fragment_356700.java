FuzzySearchQuery query = FuzzySearchQueryBuilder.create("SN41AB,WF112AB")
        .withLanguage(Locale.getDefault().toLanguageTag())
        .withCountry("GB")
        .build();

// Do stuff with the results of query.