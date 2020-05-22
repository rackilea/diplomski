public static String replaceFirst(String in, char a, char b) {
    int pos1 = in.indexOf(a);
    int pos2 = in.indexOf(b);
    if (pos2 < pos1) {
        int temp = pos2;
        pos2 = pos1;
        pos1 = temp;
    }
    StringBuilder sb = new StringBuilder();
    if (pos1 != -1 && pos2 != -1 && pos1 != pos2) {
        sb.append(in.substring(0, pos1));
        sb.append(b);
        sb.append(in.substring(pos1 + 1, pos2));
        sb.append(a);
        sb.append(in.substring(pos2 + 1));
    } else {
        sb.append(in);
    }
    return sb.toString();
}