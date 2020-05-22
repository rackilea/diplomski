@FunctionalInterface
interface PredicateBuilder<T> {

    Optional<Predicate> get(String fieldName, String value, Root<T> root, CriteriaBuilder builder);

    static Matcher getMatcher(String op, String value) {
        return getMatcher(op, value, "(.+)");
    }

    static Matcher getMatcher(String op, String value, String pattern) {
        return Pattern.compile(op + "\\(" + pattern + "\\)").matcher(value);
    }
}