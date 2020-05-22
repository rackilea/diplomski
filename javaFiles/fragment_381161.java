List<Map.Entry<String, Collection<String>>> entries = 
    new ArrayList<Map.Entry<String, Collection<String>>>(map.asMap().entrySet());
Collections.sort(entries, new Comparator<Map.Entry<String, Collection<String>>>() {
    @Override
    public int compare(Map.Entry<String, Collection<String>> e1, 
                       Map.Entry<String, Collection<String>> e2) {
        return Ints.compare(e2.getValue().size(), e1.getValue().size());
    }
});

// and now iterate
for (Map.Entry<String, Collection<String>> entry : entries) {
    System.out.println("Key = " + entry.getKey());
    for (String value : entry.getValue()) {
        System.out.println("    Value = " + value);
    }
}