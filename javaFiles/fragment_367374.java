int k = 0;
Set<String> set = new HashSet<String>(map.values());
for (String s : set) {
   int i = Collections.frequency(map.values(), s);
   k += i > 1 ? i - 1 : 0;
}