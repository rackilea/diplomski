public static void main(String[] args) {
    String input = "[123]=\"some string\" [234]=999999999 [345]=\"some other string\"";
    Pattern pattern = Pattern.compile("\\[(.*?)\\]=(.*?)( (?=\\[)|$)");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        String k = matcher.group(1);
        String v = matcher.group(2);
        System.out.println(k + "-->" + v);
    }
}