// This won't throw NPE for `obj == null`
public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
}

// This will throw `NPE` for `data == null`
public static String valueOf(char data[]) {
    return new String(data);
}