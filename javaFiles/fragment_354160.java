​List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");  
myList.stream()
       .filter{s -> s.startsWith("c")}
       .map{s-> s.toUpperCase()}
       .sorted()
       .forEach{s->println s};​