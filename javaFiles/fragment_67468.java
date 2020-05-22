List<Object[]> tmp =
    tests.getTestData().stream()
        .filter(x -> x.getUserID() == user.getUserID())  // not sure about this
                                                         // part, since it's not
                                                         // clear if the elements 
                                                         // of the input 
                                                         // Iterable have a 
                                                         // getUserID method
        .flatMap (o -> Collections.nCopies(t.getInvocationCount(it),o).stream())
        .map (o -> new Object[] {o})
        .collect (Collectors.toList());