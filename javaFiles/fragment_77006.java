public void addUnrelatedInfo(List list) {
    list.add(5);
}

//...
List<String> stringList = new ArrayList<>();
stringList.add("hello");
addUnrelatedInfo(stringList);
stringList.add("world");
System.out.println(stringList);