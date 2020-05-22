Map<String, List<Integer>> m = new HashMap<>();
m.put("test", new ArrayList<Integer>(Arrays.asList(1,2,3)));
m.put("test2", new ArrayList<Integer>(Arrays.asList(2,3,4)));

List<List<Integer>> l = new ArrayList<>(m.values());
System.out.println(l);