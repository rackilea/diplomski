Map<String, Object> in = new HashMap<>();
   in.put("key1", "val1");
   Map<String, Object> lvl1 = new HashMap<>();
   lvl1.put("key2", "val2");
   lvl1.put("key3", Collections.singletonMap("k3", "v3"));
   in.put("key2", lvl1);

   Map<String, Object> out = flatten(in);