List<List<Integer>> lolInt = null;

    List<List<?>> lolAnything = lolInt;         // DOES NOT COMPILE!!!
    // a list of "lists of anything"

    List<? extends List<?>> lolSomething = lolInt;   // compiles fine!
    // a list of "lists of something"