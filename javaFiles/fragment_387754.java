String str = "<htm><section class=\"posts\"><script type=\"application/ld+json\">{\"url\": \"http://schema.org\",          \"title\": \"some Title\"}</script><article class=\"post\"></html>";
String regex = "<script type=\"application\\/ld\\+json\">(.*)<\\/script>";
Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
  System.out.println(matcher.group(1));
}