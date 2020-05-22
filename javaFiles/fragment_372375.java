static String accum(String value) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < value.length(); i++) {
        sb.append(value.toUpperCase().charAt(i));
        sb.append(String.valueOf(value.toLowerCase().charAt(i)).repeat(i));
        sb.append("-");
    }
    return sb.deleteCharAt(sb.lastIndexOf("-")).toString();
}