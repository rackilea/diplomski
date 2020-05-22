Map<Integer, String> hm = new LinkedHashMap<>();
hm.put(100, "1111111111");
hm.put(101, "5252");
hm.put(102, "1111111111");
hm.put(103, "4589857");

Set<String> seen = new HashSet<>();
for (Map.Entry<Integer, String> e : hm.entrySet()) {
    if (!seen.add(e.getValue())) { //if (the 'seen' set already has that value)
        hm.replace(e.getKey(), UUID.randomUUID().toString().replace("-", ""));
    }
}

System.out.println(hm);