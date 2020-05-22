for (final Entry<String, List<Integer> entry : map.entrySet()) {
    final String key = entry.getKey();
    final List<Integer> value = entry.getValue();
    for (final Integer val : value) {
        list3.add(key);
        list4.add(val);
    }
}