List<String> keywords = Arrays.asList("a", "b", "c", "a");

Map<String, Integer> counts = new HashMap<String, Integer>();
for (String str : keywords) {
    if (!counts.containsKey(str))
        counts.put(str, 0);

    counts.put(str, counts.get(str) + 1);
}

int seq = 0;
for (String keyword : counts.keySet())
    if (counts.get(keyword) == 1)                      // is unique?
        System.out.println(keyword + " -> " + seq++);  // assign id.