List<List<Object>> lo = new ArrayList<List<Object>>();
List<List<? extends Object>> ll = lo;
List<String> ls = new ArrayList<String>();
ll.add(ls);
lo.get(0).add(new Object());
String s = ls.get(0); // assigns a plain Object instance to a String reference