Map<String, List<String>> myMap = new HashMap<>();//BTW, You only need to parameterize the object declaration since Java 7

List<String> names = new ArrayList<String>();
names.add("Betty");
names.add("Bob");
names.add("Jessica");
names.add("Jim");
myMap.put("names", names);//Where "names" is your key and names is your value.