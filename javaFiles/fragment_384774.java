Hashtable<String, Integer> table = new Hashtable<String, Integer>();
table.put("a", 1);
table.put("b", 2);
table.put("c", 2);
table.put("d", 2);
System.out.println(countOccurences(table, 2));