public static String parse0(String data) {
    return "#" + Integer.toString(data.length()) + ":" + data;
}

// Method that contains the real logic
private static <T> String parseInternal(T[] data, Function<T, String> parser) {
    String str = "";
    for (int i = 0; i < data.length; i++) {
        str += parser.apply(data[i]);
    }
    return str;
}

// Methods that provide the call chain:
public static String parse3(String[][][] data) {
    return parseInternal(data, arr2 -> parse2(arr2));
}

public static String parse2(String[][] data) {
    return parseInternal(data, arr -> parse1(arr));
}

public static String parse1(String[] data) {
    return parseInternal(data, str -> parse0(str));
}