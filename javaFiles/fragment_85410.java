List<HashMap<String, String>> lm = new ArrayList<HashMap<String, String>>();

HashMap<String, String> m1 = new HashMap<String, String>();
HashMap<String, String> m2 = new HashMap<String, String>();

m1.put("k1", "v1-m1");
m1.put("k2", "v2-m1");
m1.put("k3", "v3-m1");

m2.put("k1", "v1-m2");
m2.put("k3", "v1-m2");
m2.put("k3", "v1-m2");

lm.add(m1);
lm.add(m2);


lm.stream().forEach(e-> e.values().stream().forEach(ex-> System.out.println(ex)));