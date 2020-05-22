public static void replaceAllTest() {
    String textBanner = "This advertisement on $P_NAME$ will make the $P_NAME$ very popular";               
    Pattern replace = Pattern.compile("\\$(.*?)\\$"); // <-- non-greedy here with "?"
    Matcher matcherValue = replace.matcher(textBanner);
    String updatedValue = matcherValue.replaceAll("DotCom"); // <-- replaceAll to replace all matches
    System.out.println(updatedValue);
}