public static String displayCharValues(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        sb.append((int) c).append(",");
    }
    return sb.toString();
}