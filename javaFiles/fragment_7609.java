LinkedHashMap<String, List<String>> map =
        new LinkedHashMap<String, List<String>>();

map.put("1", Arrays.asList("A", "B", "C"));
map.put("2", Arrays.asList("E", "F"));
map.put("3", Arrays.asList("G"));

System.out.println(map.entrySet());
System.out.println(map.entrySet().getClass());