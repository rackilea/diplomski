NavigableSet<Integer> set = new TreeSet<>();
set.add(0);   set.add(100);
set.add(250); set.add(500);

System.out.println(set.floor(50));  // 0
System.out.println(set.floor(300)); // 250