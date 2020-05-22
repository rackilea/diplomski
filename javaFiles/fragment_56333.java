int count = myString.chars()                 // IntStream
    .map(c -> (set.add(c) ? 1 : 0))          // IntStream
    .sum();

long count = myString.chars()                // IntStream
    .filter(set::add)                        // IntStream
    .count();