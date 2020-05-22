public static String join(String[] data, String delimiter) {
    StringBuilder sb = new StringBuilder();
    if (data != null && data.length > 0) {
        for (String item : data) {
            sb.append(String.valueOf(item);
            sb.append(delimiter);
        }
        // chop off the last delimiter
        sb.setLength(sb.length() - delimiter.length());
    }
    return sb.toString();
}