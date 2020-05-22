Map<String, Integer> m1 = new HashMap<>();
m1.put("a", 10);
m1.put("b", 10);
m1.put("c", 10);

Map<String, Integer> m2 = new HashMap<>();
m2.put("c", 20);
m2.put("b", 20);
m2.put("a", 20);

System.out.println(m1.keySet().equals(m2.keySet()));  //true