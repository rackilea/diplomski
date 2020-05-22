static Object convert(Class<?> target, String s) {
    if (target == Object.class || target == String.class || s == null) {
        return s;
    }
    if (target == Character.class || target == char.class) {
        return s.charAt(0);
    }
    if (target == Byte.class || target == byte.class) {
        return Byte.parseByte(s);
    }
    if (target == Short.class || target == short.class) {
        return Short.parseShort(s);
    }
    if (target == Integer.class || target == int.class) {
        return Integer.parseInt(s);
    }
    if (target == Long.class || target == long.class) {
        return Long.parseLong(s);
    }
    if (target == Float.class || target == float.class) {
        return Float.parseFloat(s);
    }
    if (target == Double.class || target == double.class) {
        return Double.parseDouble(s);
    }
    if (target == Boolean.class || target == boolean.class) {
        return Boolean.parseBoolean(s);
    }
    throw new IllegalArgumentException("Don't know how to convert to " + target);
}