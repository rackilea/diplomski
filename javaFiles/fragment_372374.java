static String accum(String value) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < value.length(); i++) {
        sb.append(value.toUpperCase().charAt(i));
        for (int j = 0; j < i; j++) {
            sb.append(value.toLowerCase().charAt(i));
        }
        sb.append("-");
    }
    return sb.deleteCharAt(sb.lastIndexOf("-")).toString();
}