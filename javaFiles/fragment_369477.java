public static void main(String[] args) {
    String test = "qazwsx<a href=\"http://stackoverflow.com\">Take me to StackOverflow</a>fdgfdhgfd"
            + "<a href=\"http://stackoverflow2.com\">Take me to StackOverflow2</a>dcgdf";

    String regex = "<a href=(\"[^\"]*\")[^<]*</a>";

    Pattern p = Pattern.compile(regex);

    Matcher m = p.matcher(test);
    System.out.println(m.replaceAll("$1"));
}