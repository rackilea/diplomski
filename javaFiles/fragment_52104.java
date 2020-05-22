Map<String, List<Country>> countriesByLanguage = new HashMap<>();
for (Country country : countries) {
    for (String language : country.getLanguages()) {
        countriesByLanguage.computeIfAbsent(language, k -> new ArrayList<>())
                           .add(country);
    }
}