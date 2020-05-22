List<Object[]> tmp =
    tests.getTestData().stream()
        .filter(x -> x.getUserID() == user.getUserID())  // not sure about this
                                                         // part, since it's not
                                                         // clear if the elements 
                                                         // of the input 
                                                         // Iterable have a 
                                                         // getUserID method
        .flatMap (x -> IntStream.range(0,t.getInvocationCount(it)).mapToObj(i -> x))
        .map(o -> new Object[] {o})
        .collect (Collectors.toList());