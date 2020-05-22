myObjs.stream()
    .flatMap(o -> {
        try {
            ABC.doStuff(o);
            return null;
        } catch (RuntimeException ex) {
            return Stream.of(ex);
        }
    })
    // now a stream of thrown exceptions.
    // can collect them to list or reduce into one exception
    .reduce((ex1, ex2) -> {
        ex1.addSuppressed(ex2);
        return ex1;
    }).ifPresent(ex -> {
        throw ex;
    });