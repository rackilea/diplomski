public static String getChristmassTree(int size) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - i; j++) {
            sb.append(" ");
        }
        for (int k = 0; k < (2 * i + 1); k++) {
            sb.append("*");
        }
        sb.append("\n");
    }
    for (int j = 0; j < size; j++) {
        sb.append(" ");
    }
    sb.append("**");       // don't need a loop here 
    return sb.toString();
}