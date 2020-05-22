List<String> words = 
    Files.lines(Paths.get(this.File_Path), charSetOfYourFileIfNotUTF8) // Stream<String>
         .parallel()
         .flatMap(s-> Arrays.stream(s.split("\\PL+"))) // Stream<String>
         .filter(x -> x.contains(toMatch))
         .distinct()
         .collect(Collectors.toList());