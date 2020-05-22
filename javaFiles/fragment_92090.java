public static String toString(Object[] a) {
    if (a == null)
        return "null";
    int iMax = a.length - 1;
    if (iMax == -1)
        return "[]";

    StringBuilder b = new StringBuilder();
    b.append('[');
    for (int i = 0; ; i++) {
        b.append(String.valueOf(a[i]));  // Let's print that!
        if (i == iMax)
            return b.append(']').toString();
        b.append(", ");
    }
}