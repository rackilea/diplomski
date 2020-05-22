public static String padLeft(String s, int n) {
    if (n <= 0)
        return s;
    int noOfSpaces = n * 2;
    StringBuilder output = new StringBuilder(s.length() + noOfSpaces);
    while (noOfSpaces > 0) {
        output.append(" ");
        noOfSpaces--;
    }
    output.append(s);
    return output.toString();
}