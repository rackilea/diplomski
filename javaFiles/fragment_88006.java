public static void main(String[] args) {
    String regex = "from (.*) to";
    String sentence = "User update personal account ID from P150567 to A250356.";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(sentence);
    matcher.find();
    System.out.println(matcher.group(1));
}