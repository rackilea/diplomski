String url = "https://www.horisen.com/";
    String[] countryCodes = {"de", "se", "dk", "fr", "en", "fi"};
    for (String countryCode : countryCodes) {
        String countryUrl = url + countryCode;
        System.out.println(countryUrl);
    }