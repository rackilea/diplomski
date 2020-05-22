private static void replaceValue(String tag, String value) {
    String regex = "<(.*?)>(.*?)</(.*?)>";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(content);

    if (matcher.find()) {                                                
        content = content.replaceAll(matcher.group(1), tag)
                .replaceAll(matcher.group(2), value)
                .replaceAll(matcher.group(3), tag);
    }
    System.out.println(content);
}