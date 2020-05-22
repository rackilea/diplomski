List<String> test = new ArrayList<String>();
// added in "random" order
test.add("1.2.3");
test.add("1.5");
test.add("4.0.1");
test.add("1.1");
test.add("1.1.2");
test.add("1.1.2.2");
// no Comparator given as second argument ==> 
// default comparator for String, which is lexicographical
Collections.sort(test);
System.out.println(test);