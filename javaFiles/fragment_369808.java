private static String getStoredFilter(String filterVal) {
    String key = canonical(filterVal);

    // check whether there's an exact match
    String quickChecked = formatLookup.get(key);
    if(quickChecked!=null) return quickChecked;

    // search for substring matches
    return formatLookup.entrySet().stream()
        .filter(e -> e.getKey().contains(key))
        .map(Map.Entry::getValue)
        .findAny().orElse(null);
}