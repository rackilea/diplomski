int cheapestPrice = students.stream()
    .flatMap(s -> s.getBookSet().stream())
    .mapToInt(Book::getPrice)
    .min().orElse(0);

Set<Student> readingCheapestBooks = students.stream()
    .collect(filtering(s -> s.getBookSet().stream().anyMatch(b -> b.getPrice() <= cheapestPrice), 
             toSet()));