public static String mixCase(String in) {
    StringBuilder sb = new StringBuilder();
    if (in != null) {
        char[] arr = in.toCharArray();
        if (arr.length > 0) {
            char f = arr[0];
            boolean first = Character.isUpperCase(f);
            for (int i = 0; i < arr.length; i++) {
                sb.append((first) ? Character.toLowerCase(arr[i])
                        : Character.toUpperCase(arr[i]));
                first = !first;
            }
        }
    }
    return sb.toString();
}