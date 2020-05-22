/**
 * Returns {@code true} if and only if both the arguments (objects) are
 * <b>not</b> {@code null} and are not equal to each other and {@code false}
 * otherwise.
 *
 * @param a an object.
 * @param b an object to be compared with {@code a} for equality.
 * @return {@code true} if both the arguments (objects) are <b>not</b> {@code null}
 * and not equal to each other.
 */
public static boolean notEquals(Object a, Object b) {
    return (a == b || a == null || b == null) ? false : !a.equals(b);
}