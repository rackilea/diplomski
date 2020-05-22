class PredicateUtils {

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

}