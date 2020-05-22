String fileName = null;
Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
Matcher regexMatcher = regex.matcher(requestHeaderString);
if (regexMatcher.find()) {
    fileName = regexMatcher.group();
}