List<Integer> results = new ArrayList<>();
for (int i = 0; i < list.size(); i++) {
    if (search == list.get(i).intValue()) {
        // found value at index i
        results.add(i);
    }
}