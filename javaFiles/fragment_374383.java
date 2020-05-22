public static String arrayToString(Object o) {
    if(o instanceof Object[])  {
        return Arrays.deepToString((Object[]) o);
    }
    else if(o instanceof long[]) {
        return Arrays.toString((long[]) o);
    }
    else if(o instanceof int[]) {
        return Arrays.toString((int[]) o);
    }
    else if(o instanceof short[]) {
        return Arrays.toString((short[]) o);
    }
    else if(o instanceof byte[]) {
        return Arrays.toString((byte[]) o);
    }
    else if(o instanceof float[]) {
        return Arrays.toString((float[]) o);
    }
    else if(o instanceof double[]) {
        return Arrays.toString((double[]) o);
    }
    else if(o instanceof boolean[]) {
        return Arrays.toString((boolean[]) o);
    }
    throw new IllegalArgumentException("input is not an array");
}