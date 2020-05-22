// import static java.util.stream.Collectors.*
Map<Integer, Map<Integer, Map<Integer, List<FileObject>>>> result2 = files.stream()
    .filter(f -> f.sizeInBytes < MAX_SIZE_THRESHOLD)
    .collect(groupingBy(f -> f.getYear(), 
                        groupingBy(f -> f.getMonth(), 
                                        groupingBy(f -> f.getDay(), toList()))));

result2.entrySet().forEach(System.out::println);