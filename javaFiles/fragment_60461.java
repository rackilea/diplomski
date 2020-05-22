ResultType result;
    try(Stream<T> s = parseFile(file)) {
        result = s.
         // other intermediate ops
         // terminal operation
    }
    finally {
        // other cleanup actions
    }