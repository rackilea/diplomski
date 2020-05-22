public static void main(String[] args) {
    System.out.println(processAction("{\"action\":\"stop\"}"));
    System.out.println(processActionRegex("{\"action\":\"go\"}"));
}

private static String processAction(String actionJson) {     
    return actionJson.substring(actionJson.indexOf(":\"") + 2, actionJson.lastIndexOf("\""));
}

private static String processActionRegex(String actionJson) {
    Pattern pattern = Pattern.compile("\\{\"(\\w+)\":\"(\\w+)\"\\}");
    Matcher matcher = pattern.matcher(actionJson);

    String result = "";
    if (matcher.matches()) {
        result = matcher.group(2);
    } else {
        // Throw exception?
    }

    return result;
}