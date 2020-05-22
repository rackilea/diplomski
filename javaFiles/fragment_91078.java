try (Stream<String> stream = Files.lines(Paths.get("test.txt"))) {
    Map<String,List<String>> map =  stream.collect(Collectors.groupingBy(s->s.substring(0, 3)));
    map.getOrDefault("aaa", map.get("bbb")).forEach(System.out::println);            
} 
catch (IOException e) {
}