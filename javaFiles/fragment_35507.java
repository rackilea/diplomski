public static <T extends Comparable<T>> Predicate<T> predicate(String op, T compVal) {
    switch (op) {
        case "=": return p -> p.compareTo(compVal) == 0;
        case "<": return p -> p.compareTo(compVal) < 0;
        case "<=": return p -> p.compareTo(compVal) <= 0;
        case ">": return p -> p.compareTo(compVal) > 0;
        case ">=": return p -> p.compareTo(compVal) >= 0;
        default: return p -> false;
    }
}