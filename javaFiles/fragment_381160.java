List<Map.Entry<String, String>> entries = new ArrayList<Map.Entry<String, String>>(map.entries());
Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {
    @Override
    public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
        return Ints.compare(map.get(e2.getKey()).size(), map.get(e1.getKey()).size());
    }
});