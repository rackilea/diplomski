List<String> minDup = new ArrayList<>();
Map<String,List<String>> map = new HashMap<>();

for(String s: a1) {
    map.computeIfAbsent(s.substring(0, 10), x -> new ArrayList<>()).add(s);
}
for(List<String> list: map.values()) {
    if(list.size() > 1) minDup.add(Collections.min(list));
}