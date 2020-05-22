// Create a map that orders its data.
Map<Integer, String> tmp = new TreeMap<>();

// Put your data into this structure and let it sort the data for you.
for (int i=0; i<keys.size(); i++) {
    tmp.put(keys.get(i), values.get(i));
}

// Clear your original lists.
keys.clear()
values.clear();

// Put the data back into your lists - but sorted this time.
for (Integer key : tmp.keySet()) {
    keys.add(key);
    values.add(tmp.get(key));
}