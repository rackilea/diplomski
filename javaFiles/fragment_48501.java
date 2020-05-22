public static Map<String, String> getAttributes(String attributes) {
    Map<String, String> attr = new HashMap<>();
    Matcher m = Pattern.compile("(\\w+)=(.*?)(?=,\\w+=|$)").matcher(attributes);
    while (m.find()) {
        attr.put(m.group(1), m.group(2));
    }
    return attr;
}