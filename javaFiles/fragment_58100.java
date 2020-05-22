Map<String, Integer> counter = new LinkedHashMap<String, Integer>();
for (String s : list1) {
    if (counter.containsKey(s))
        counter.put(s, counter.get(s) + 1);
    else
        counter.put(s, 1);
}