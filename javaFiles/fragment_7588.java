String pattern = "https?:\\/\\/(?:[0-9A-Z-]+\\.)?(?:youtu\\.be\\/|youtube\\.com\\S*[^\\w\\-\\s])([\\w\\-]{11})(?=[^\\w\\-]|$)(?![?=&+%\\w]*(?:['\"][^<>]*>|<\\/a>))[?=&+%\\w]*";

Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
Matcher matcher = compiledPattern.matcher(link);
while(matcher.find()) {
    System.out.println(matcher.group());
}