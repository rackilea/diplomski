private static Map<String, Integer> ordering;
static {
    ordering = new HashMap<>();
    ordering.add("tower", 1);
    ordering.add("car", 2");
    ...add your other strings with increasing values...
}

Collections.sort(yourCollection, new Comparator<Places>() {
    public int compare(Places p1, Places p2) {
        return ordering.get(p1.label) - ordering.get(p2.label);
    }
});