List<String> list = abc("foo");
System.out.println(list.size());
list.add("bar");
for (String value : list) {
    System.out.println(value);
}