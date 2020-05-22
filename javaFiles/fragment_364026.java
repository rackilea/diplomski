private final static long KB_FACTOR = 1024;
private final static long MB_FACTOR = 1024 * KB_FACTOR;
private final static long GB_FACTOR = 1024 * MB_FACTOR;

public static double parse(String arg0) {
    int spaceNdx = arg0.indexOf(" ");
    double ret = Double.parseDouble(arg0.substring(0, spaceNdx));
    switch (arg0.substring(spaceNdx + 1)) {
        case "GB":
            return ret * GB_FACTOR;
        case "MB":
            return ret * MB_FACTOR;
        case "KB":
            return ret * KB_FACTOR;
    }
    return -1;
}