LinkedHashSet<String> uniqueStrings = new LinkedHashSet<String>();

uniqueStrings.add("A");
uniqueStrings.add("B");
uniqueStrings.add("B");
uniqueStrings.add("C");
uniqueStrings.add("A");

List<String> asList = new ArrayList<String>(uniqueStrings);
System.out.println(asList);