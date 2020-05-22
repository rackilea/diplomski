List<?> list;
List<Integer> ints = new ArrayList<Integer>();
List<Integer> strings = new ArrayList<Integer>();
list = ints; // valid
list = strings; // valid
list.add("new"); // compile error