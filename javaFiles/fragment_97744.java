Map<String, List<Object>> mp = new HashMap<>();

for (int k = 65; k <= 91; k++) {
    List<Object> l = new ArrayList<>();
    l.add((char)k);
    mp.put(Integer.toString(k), l);
}

System.out.println(mp);