private static void putNonNull(String key, String value, 
                               Map<String, String> map) {
    if(value != null) {
        map.put(key, value);
    }
}

putNonNull("AA", "EN", Cert);
putNonNull("BB", "EN", Cert);
putNonNull("CC", ccLang, Cert);