Map<String, String> m = new HashMap<String, String>();
m.put("key1", "value1");
m.put("key2", null);

System.out.println("m.get(\"key1\")=" + m.get("key1"));
System.out.println("m.containsKey(\"key1\")=" + m.containsKey("key1"));

System.out.println("m.get(\"key2\")=" + m.get("key2"));
System.out.println("m.containsKey(\"key2\")=" + m.containsKey("key2"));

System.out.println("m.get(\"key3\")=" + m.get("key3"));
System.out.println("m.containsKey(\"key3\")=" + m.containsKey("key3"));