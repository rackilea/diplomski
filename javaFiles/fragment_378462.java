private <C, P> Predicate<P> compare(
    Function<P, String> valueFunction,
    BiPredicate<? super String, C> matchPredicate, C value) {

    return p -> {
        Individu individu = individuLightSVC.donneIndividu(valueFunction.apply(p), null);
        String stringToCompare = individu.getPrenom() + " " + individu.getNom();
        return matchPredicate.test(stringToCompare, value);
    };
}