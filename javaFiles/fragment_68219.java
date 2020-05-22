List<String> myStrings = new ArrayList<String>();
myStrings.add("a");
myStrings.add("b");
myStrings.add("c");
myStrings.add("d");
myStrings.add("e");
myStrings.add("f");
Collections.shuffle(myStrings);
System.out.println(myStrings.subList(0, 4));