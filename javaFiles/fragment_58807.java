String[] texts = { "aa aab aa aab", "111111111 1" };
String[] toReplace = { "aa", "1" };
String[] toReplaceWith = { "--", "-" };
for (int i = 0; i < texts.length; i++) {
    String text = texts[i];
    text = text.replaceAll("\\b" + toReplace[i] + "\\b", toReplaceWith[i]);
    System.out.println(text);
}