public static String encode(String s) {
    if (s == "" || s == null)
        return "";
    StringBuilder sb = new StringBuilder();
    int count = 1;
    char previous = s.charAt(0);
    char current;

    for (int i = 1; i < s.length(); i++) {
        current = s.charAt(i);
        if (current == previous) {
            count++;
        } else {
            if (count == 1) {
                sb.append(previous);
            } else if (count > 1) {
                if (count > 9) {
                    sb.append(9).append(previous);
                    sb.append(count - 9).append(previous);
                } else {
                    sb.append(count).append(previous);
                }
                count = 1;
            }
        }
        previous = current;

    }
    sb.append(count).append(previous);
    return sb.toString();
}