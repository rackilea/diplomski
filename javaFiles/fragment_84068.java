import org.eclipse.persistence.internal.jpa.querydef.SelectionImpl;

public static String getPredicateAsString(final Predicate predicate) {
    if (predicate == null) {
        return null;
    }
    if (!(predicate instanceof SelectionImpl<?>)) { // type guard
        return "not supported";
    }

    return ((SelectionImpl<?>) predicate).getCurrentNode().toString();
}