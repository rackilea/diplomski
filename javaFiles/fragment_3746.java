Map<String, Integer> results = new LinkedHashMap<String, Integer>();
for (String s : listOfAllStrings) {
    if (results.get(s) != null) {
        results.put(s, results.get(s) + 1);
    } else {
        results.put(s, 1);
    }
}