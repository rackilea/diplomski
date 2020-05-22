public String replace(String text) {
    String text = "My name is %NAME%.";
    String pattern = "%NAME%";
    String textReplaced = "Darius";

    String[] result = text.split(" ");
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < result.length; i++) {
        sb.append(result[i].contains(pattern) ? textReplaced + " " : result[i] + " ");
    }

    return sb.toString();
}