List<String> strings = new ArrayList<>(Arrays.asList("A", "B", "C"));
Iterator<String> iter = strings.iterator();
while(iter.hasNext()){
    String string = iter.next();
    if ("B".equals(string))
        strings.remove("B");
}
System.out.println(strings);