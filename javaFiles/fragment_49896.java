public static String removeDashes(String phoneNumber) {
    StringBuilder sb = new StringBuilder();
    for (char ch : phoneNumber.toCharArray()) {
        if (ch != '-') {
            sb.append(ch);
        }
    }
    return sb.toString();
}