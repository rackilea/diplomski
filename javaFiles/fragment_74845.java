List<Entry<String, Integer>> l = new ArrayList<>(map.entrySet());

Collections.sort(l, new Comparator<Entry<?, Integer>>() {
    @Override
    public int compare(Entry<?, Integer> a, Entry<?, Integer> b) {
        return b.getValue().compareTo(a.getValue());  // reverse order
    }
});

for (int i = 0; i < 10; i++) {
    Entry<String, Integer> e = l.get(i);
    System.out.println(e.getKey() + " is " + e.getValue());
}