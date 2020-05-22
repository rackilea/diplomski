static List<Integer> getIdFromIsbn(String isbn, Map<Integer, Map<String, Integer>> map) {
    List<Integer> list = new ArrayList<>();

    for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
        Map<String, Integer> value = entry.getValue();
        for (Map.Entry<String, Integer> subEntry : value.entrySet()) {
            if (subEntry.getKey().equals(isbn)) {
                list.add(entry.getKey());
            }
        }
    }

    return list;
}