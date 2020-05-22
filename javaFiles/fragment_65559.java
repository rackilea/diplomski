private String findCor(String string) {
    char[] b = string.toCharArray();

    StringBuilder sb = new StringBuilder();
    sb.append("");

    for (int i = 0; i < (b.length-1); i++) {
        if ((b[i] == ChatColor.COLOR_CHAR) && ("0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[(i + 1)]) > -1)) {
            sb.append(b[i]);
            sb.append(b[(i + 1)]);
        }
    }
    return sb.toString();
}