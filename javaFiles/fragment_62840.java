public static String getCTScanSite(String val) {
    Multimap<String, String> map = HashMultimap.create();

    map.put("07", "069");
    map.put("01", "073");
    map.put("04", "085");
    map.put("01", "086");
    map.put("96", "099");
    map.put("112", "100");
    map.put("01", "101");
    map.put("109", "102");
    map.put("106", "103");
    map.put("119", "104");
    Multimap<String, String> invertedMap = Multimaps.invertFrom(map, ArrayListMultimap.<String, String>create());
    return invertedMap.get(val);
}