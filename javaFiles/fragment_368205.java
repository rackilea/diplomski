CSV csv = new CSV();
try (Stream<String> stream = Files.lines(Paths.get(fullname))) {
    stream.forEach(t -> {
        List<String> splittedString = splitFileRow(t);
        csv.add(splittedString);  
    });