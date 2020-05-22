/**
 * Implements the Unicode category ALL and the dot metacharacter when
 * in dotall mode.
 */
static final class All extends CharProperty {
boolean isSatisfiedBy(int ch) {
    return true;
}
}

/**
 * Node class for the dot metacharacter when dotall is not enabled.
 */
static final class Dot extends CharProperty {
boolean isSatisfiedBy(int ch) {
    return (ch != '\n' && ch != '\r'
                && (ch|1) != '\u2029'
                && ch != '\u0085');
    }
}