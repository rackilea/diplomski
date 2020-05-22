Map<Integer, String> p = new TreeMap<>();
p.put(1, "w");
p.put(2, "x");
p.put(3, "y");
p.put(4, "z");
System.out.println(p);// {1=w, 2=x, 3=y, 4=z}

Set<Integer> s = p.keySet();
System.out.println(s);// [1, 2, 3, 4]

System.out.println(s.contains(1)); // true
System.out.println(s.remove(1));// true
System.out.println(p);// {2=x, 3=y, 4=z}
System.out.println(s);// [2, 3, 4]