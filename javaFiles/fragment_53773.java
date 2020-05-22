private static String cleanMessage(String in) {
    StringBuilder sb = new StringBuilder();
    for (Character i : in.toCharArray()) {
        int charInt = i.hashCode();
        if (charInt >= 32 && charInt <= 126) {
            sb.append(i);
        }
    }
    return sb.toString();
}