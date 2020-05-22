String pattern = "\\$\\{([A-Za-z0-9]+)\\}";
Pattern expr = Pattern.compile(pattern);
Matcher matcher = expr.matcher(text);
while (matcher.find()) {
    String envValue = envMap.get(matcher.group(1).toUpperCase());
    if (envValue == null) {
        envValue = "";
    } else {
        envValue = envValue.replace("\\", "\\\\");
    }
    Pattern subexpr = Pattern.compile(Pattern.quote(matcher.group(0)));
    text = subexpr.matcher(text).replaceAll(envValue);
}