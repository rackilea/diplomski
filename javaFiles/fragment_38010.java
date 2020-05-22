list.stream() // List.stream() returns an ordered stream
    .unordered() // releases order contract
    .distinct() // for equal elements, it may pick an arbitrary one
    .sorted() // re-introduces an order
    .skip(1) // will skip the minimum element due to the order
    .forEach(System.out::println); // may print the remaining elements in arbitrary order