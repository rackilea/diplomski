List<String> keys = new ArrayList<>();
for (Entry<String, Integer> entry : map.entrySet()) {
    if (entry.getValue()==max) {
        keys.add(entry.getKey());
    }
}