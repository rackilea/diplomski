Map<String, List<Object>> mp = new HashMap<>();

List<Object> l = new ArrayList<>();
for (int k = 65; k <= 91; k++) {
    l.add((char)k);
    mp.put(Integer.toString(k), l);
}

l.clear();
System.out.println(mp);