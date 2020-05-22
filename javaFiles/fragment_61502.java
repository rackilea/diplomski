public static String join(String begin, String end) {
    for (int i = end.lastIndexOf("\\"); i >= 0; i = end.lastIndexOf("\\", i - 1)) {
        if (begin.endsWith(end.substring(0, i)) && begin.charAt(begin.length() - (i+1)) == '\\') {
            return begin + end.substring(i);
        }
    }
    return "strings dont contain same folder sequence";
}