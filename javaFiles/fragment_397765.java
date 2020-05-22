Map<Integer, String> p = new TreeMap<>();
p.put(1, "w");
p.put(2, "x");
p.put(3, "y");
p.put(4, "z");
System.out.println(p);// {1=w, 2=x, 3=y, 4=z}

Set<Map.Entry<Integer, String>> s = p.entrySet();
System.out.println(s);// [1=w, 2=x, 3=y, 4=z]

Map.Entry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "foo");
System.out.println(s.contains(entry)); // false (not containing {1=foo})

entry.setValue("w");
System.out.println(s.contains(entry)); // true (containing {1=w})
System.out.println(s.remove(entry));// true
System.out.println(p);// {2=x, 3=y, 4=z}
System.out.println(s);// [2=x, 3=y, 4=z]