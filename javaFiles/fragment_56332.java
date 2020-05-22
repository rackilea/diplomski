int count = myString.chars()                 // IntStream
    .map(c -> (set.add((char) c) ? 1 : 0))   // IntStream
    .sum();

long count = myString.chars()                // IntStream
    .filter(c -> set.add((char) c))          // IntStream
    .count();