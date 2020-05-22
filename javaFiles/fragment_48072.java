public static String prepareHtmlToJLabelText(Class relativeClass, String html) {
    Pattern p = Pattern.compile("src=['\"](.*?)['\"]");
    Matcher m = p.matcher(html);
    while (m.find()) {
        html = html.replace(m.group(), "src='" + relativeClass.getResource(m.group(1)) + "'");
    }
    return html;
}