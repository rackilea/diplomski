List<Map<String, Integer>> items = new ArrayList<>();

for (int i = 0; i < items.size(); i++) {
    String key = null;
    int value = 0;
    for (Map.Entry<String, Integer> entry: items.get(i).entrySet()) {
        if (value == (entry.getValue())) {
            key = (String) entry.getKey();
            break;
        }
    }
}