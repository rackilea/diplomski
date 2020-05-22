List<String> list = new ArrayList<String>();
Set<String> set = new HashSet<String>();
list.add("M1");
list.add("M1");
list.add("M2");
list.add("M3");

set.addAll(list);
System.out.println(set.size());