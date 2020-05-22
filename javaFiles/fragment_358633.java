Map<ArrayList<String>, String> map = new HashMap<>();

ArrayList<String> l = new ArrayList<>();
l.add("a");
l.add("b");

map.put(l, "Hello");
System.out.println(map.get(l)); // "Hello";

l.add("c"); // Mutate key.
System.out.println(map.get(l)); // null (value lost!)