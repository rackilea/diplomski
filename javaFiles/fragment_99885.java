for (final Triplet z : tripletsTwo) {
    for (final Triplet x : mapOneByNoun1.getOrDefault(z.noun1, EMPTY)) {
        for (final Triplet y : mapOneByNoun2.getOrDefault(z.noun2, EMPTY)) {
            doSomething(x, y);
        }
    }
}