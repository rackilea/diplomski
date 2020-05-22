Map<String, List<String>> var = 
    files.stream()
         .collect(Collectors.groupingBy(
             File::getParent,
             Collectors.mapping(File::getName, Collectors.toList())
         ));