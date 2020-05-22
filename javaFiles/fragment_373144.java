public static <T> boolean hasSize(Object x, int expectedSize)
{
    return (x != null) && x.getClass().isArray() ?
        java.lang.reflect.Array.getLength(x) == expectedSize :
        false;
}