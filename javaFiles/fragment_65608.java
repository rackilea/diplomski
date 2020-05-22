Map<String, Integer> sMap = 
    ddMap.stream()
         .flatMap(x -> x.stream())
         .distinct()
         .collect(Collectors.toMap(Function.identity(),
                                   String::length));