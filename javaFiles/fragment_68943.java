private static final Pattern p = Pattern.compile("^([a-zA-Z]+)([0-9]+)(.*)");
public static void main(String[] args) {
    // create matcher for pattern p and given string
    Matcher m = p.matcher("Testing123Testing");

    // if an occurrence if a pattern was found in a given string...
    if (m.find()) {
        // ...then you can use group() methods.
        System.out.println(m.group(0)); // whole matched expression
        System.out.println(m.group(1)); // first expression from round brackets (Testing)
        System.out.println(m.group(2)); // second one (123)
        System.out.println(m.group(3)); // third one (Testing)
    }
}