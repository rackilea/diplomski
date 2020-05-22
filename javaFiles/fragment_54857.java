public static void main(String[] args) throws Exception {
    System.out.println("Regex: ");
    String data = "M:<some text>:D:tcp://someurl.something:port:C:<some more text>:Q:<a number>";
    Matcher matcher = Pattern.compile("M:(.*):D:(.*):C:(.*):Q:(.*)").matcher(data);
    if (matcher.matches()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
    }
    System.out.println();

    System.out.println("String.split(): ");
    String[] pieces = data.split("M:|:D:|:C:|:Q:");
    for (String piece : pieces) {
        System.out.println(piece);
    }
}