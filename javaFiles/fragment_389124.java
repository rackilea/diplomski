List<String> list = ArrayList<>();
Map<String, Integer> counts = new HashMap<>();
// Fill list with values....

for (String item:list) {
    Integer count = counts.get(item);
    if (count == null) {
        // This is the first time we have seen item, so the count should be one.
        count = 1;
    } else {
        // Increment the count by one.
        count = count + 1;
    }
    counts.put(item, count);
}

// Print them all out.
for (Entry<String, Integer> entry : counts.entrySet()) {
    System.out.println(entry.getValue() + " " + entry.getKey());
}