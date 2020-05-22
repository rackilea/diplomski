String pattern1 = "hgb";
String pattern2 = "|";
String text = "sdfjsdkhfkjsdf hgb sdjfkhsdkfsdf |sdfjksdhfjksd sdf sdkjfhsdkf | sdkjfh hgb sdkjfdshfks|";

Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
Matcher m = p.matcher(text);
while (m.find()) {
  System.out.println(m.group(1));
}