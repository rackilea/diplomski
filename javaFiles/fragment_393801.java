public static void main(String[] args) throws Exception {
    String setString = "Set aaa = bbb";
    Matcher matcher = Pattern.compile("Set (.+?) = (.+?)").matcher(setString);

    if (matcher.matches()) {
        System.out.println("Success");
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    } else {
        System.out.println("Failed");
    }
}