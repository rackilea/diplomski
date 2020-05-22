List<String> a1 = Arrays.asList("1070045028000", "1070045028001",
    "1070045052000", "1070045086000", "1070045052001", "1070045089000");

Set<String> unique = new HashSet<>();
Map<String,String> map = new HashMap<>();

for(String s: a1) {
    String firstTen = s.substring(0, 10);
    if(!unique.add(firstTen)) map.put(firstTen, s);
}
for(String s1: a1) {
    String firstTen = s1.substring(0, 10);
    map.computeIfPresent(firstTen, (k, s2) -> s1.compareTo(s2) < 0? s1: s2);
}
List<String> minDup = new ArrayList<>(map.values());