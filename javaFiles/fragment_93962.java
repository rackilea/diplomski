public static List<String> splitWithDelimiter(String text, String delimiter) {
    String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    String regex = String.format(WITH_DELIMITER, delimiter);
    String matcher = "[a-zA-Z]*[0-9]+";
    String[] s = text.split(regex);
    List<String> result = new ArrayList<>();
    String tmp = "";
    for (String x : s) {
        if (x.matches(matcher)) {
            tmp += x;
        } else {
            if (!tmp.isEmpty()) {
                result.add(tmp);
                tmp = "";
            }
            result.add(x);
        }
    }
    if(!tmp.isEmpty()) {
        result.add(tmp);
    }
    return result;
}

public static void main(String[] args) {
    String test = "=(7+A185)-5";
    String delimiter = "[a-zA-Z]{1,4}[0-9]{1,4}";
    List<String> s = splitWithDelimiter(test, delimiter);
    for (String x : s) {
        System.out.println(x);
    }
}