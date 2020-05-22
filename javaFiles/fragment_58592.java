Pattern p = Pattern.compile("^(\\D*[^\\d\\s])\\s*(\\d.*)", Pattern.DOT_ALL);
Matcher m = p.matcher(myString);
if (m.find()) {
  String appName = m.group(1);
  String versionNumber = m.group(2);
  ...
}