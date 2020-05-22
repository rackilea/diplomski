public static String humanReadableByteCountSI(long bytes) {
    String s = bytes < 0 ? "-" : "";
    long b = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
    return b < 1000L ? bytes + " B"
            : b < 999_950L ? String.format("%s%.1f kB", s, b / 1e3)
            : (b /= 1000) < 999_950L ? String.format("%s%.1f MB", s, b / 1e3)
            : (b /= 1000) < 999_950L ? String.format("%s%.1f GB", s, b / 1e3)
            : (b /= 1000) < 999_950L ? String.format("%s%.1f TB", s, b / 1e3)
            : (b /= 1000) < 999_950L ? String.format("%s%.1f PB", s, b / 1e3)
            : String.format("%s%.1f EB", s, b / 1e6);
}