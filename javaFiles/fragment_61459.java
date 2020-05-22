Pattern pattern = Pattern.compile("(?U)[\\w]");
String str = "功能 絶顯示廣告";

Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.toMatchResult().group());
}