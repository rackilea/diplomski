public static void main(String[] args) throws Exception {
    String data = "this \"is a test\" now \"hello\" goodbye";

    Matcher matcher = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'").matcher(data);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}