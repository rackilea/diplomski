public static void main(String[] args) {
    List<String> inputs = Arrays.asList("AAAAAAAAA", "ABABAB", "ABCAB", "ABAb");
    for (String s : inputs) System.out.println(findPattern(s));
}

private static String findPattern(String s) {
    String output = s;
    String temp;
    while (true) {
        temp = output.replaceAll("(.+)\\1", "$1");
        if (temp.equals(output)) break;
        output = temp;
    }
    return output;
}