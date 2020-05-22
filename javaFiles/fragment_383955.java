public static void main(String... args) {

    Pattern pattern = Pattern.compile(
            "(?<!\\[video\\])(?:https|http)://([^\\s\\|]+)(?!\\[video\\])");

    String text = "This is some example text with a link" +
        "[video]http://videolink[video] that should not be replaced" + 
        "and another link that should be" +
        "replaced http://www.example.com";

    Matcher m = pattern.matcher(text);

    StringBuffer sb = new StringBuffer();
    while (m.find())
        m.appendReplacement(sb, "<a href=\""+m.group()+"\">"+m.group() +"</a>");
    m.appendTail(sb);

    System.out.println(sb);
}