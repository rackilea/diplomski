private static final Pattern REGEX_PATTERN = 
        Pattern.compile(":[^:]*?ced");

public static void main(String[] args) {
    String input = "abc|s:0:\"gef\";s:2:\"ced\"";
    System.out.println(java.util.Arrays.toString(
        REGEX_PATTERN.split(input)
    )); // prints "[abc|s:0:"gef";s:2, "]"
}