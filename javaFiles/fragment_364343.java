public String replace(String text) {
    String text = "My name is %NAME%.";
    String pattern = "%NAME%";
    String textReplaced = "Darius";

    String result = text.replace(pattern, textReplaced);
    System.out.println(result);
    return result;
}