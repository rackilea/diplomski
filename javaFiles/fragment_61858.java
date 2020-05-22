String output = 
    "input_goes_here"
    .codePoints()                            // Generates an `IntStream` of Unicode code points, one `Integer` for each character in the string.
    .collect(                                // Collect the results of processing each code point.
        StringBuilder::new,                  // Supplier<R> supplier
        StringBuilder::appendCodePoint,      // ObjIntConsumer<R> accumulator
        StringBuilder::append                // BiConsumer<R,​R> combiner
    )                                        
    .toString()
;