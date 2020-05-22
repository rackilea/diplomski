List<Map<String, String>> merged = new ArrayList<Map<String, String>>();
for (Map<String, String> map1 : list1) {
    boolean found = false;
    for (Map<String, String> map2 : list2) {
        if (map1.get("id").equals(map2.get("id"))) {
            found = true;
            Map<String, String> copy = new HashMap<String, String>();
            copy.putAll(map1);
            copy.putAll(map2);
            merged.add(copy);
        }
    }
    if (!found) {
        merged.add(map1);
    }
}