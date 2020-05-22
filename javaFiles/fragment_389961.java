Map<String, String> countryLanguageMap = new HashMap<String, String>() {{
    put("France", "French");
    put("Germany", "German");
    put("USA", "English");
}};

String country = "USA";
String language = countryLanguageMap.get(country);
if (language == null) throw new IllegalArgumentException("No mapping for country " + country);