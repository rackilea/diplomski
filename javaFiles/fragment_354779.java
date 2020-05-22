public static String replace(String input, String... values) {
    StringBuffer buf = new StringBuffer();
    Matcher m = Pattern.compile("\\|{2}(.*?)\\|{2}").matcher(input);
    for (int i = 0; m.find(); i++)
        m.appendReplacement(buf, (i < values.length ? values[i] : m.group(1)));
    return m.appendTail(buf).toString();
}