Map<String, List<String>> groups = ulpList.stream().collect(Collectors.groupingBy(e -> e.split(",")[0]));

ArrayList<List<String>> sorted = new ArrayList<>();
for (List<String> s : groups.values()) {
    sorted.add(s.stream().sorted((s1, s2) -> {
        long ts1 = Long.valueOf(s1.split(",")[1]);
        long ts2 = Long.valueOf(s2.split(",")[1]);
        return Long.compare(ts1, ts2);
    }).collect(Collectors.toList()));
}
// do calculations 
// ...