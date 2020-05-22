List<String> strings = new ArrayList<String>();
strings.add("x");
Object o = strings;

// Warning, but will succeeed at execution time
List<Integer> integers = (List<Integer>) o;
Integer i = integers.get(0); // Bang!