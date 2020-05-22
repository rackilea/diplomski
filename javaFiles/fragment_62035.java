List<String> strList = new ArrayList<String>();
strList.add("Alpha");
strList.add("Beta");
strList.add("Charlie");
strList.add("Delta");
strList.add("Delta");
strList.add("Delta");

strList = strList.stream().distinct().collect(Collectors.toList());
System.out.println("Without duplicate");
strList.forEach(System.out::println);