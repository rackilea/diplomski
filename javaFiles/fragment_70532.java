Pattern regex = Pattern.compile("by_(.*)_on");
String str = "Files_by_wesasegeaazedude_on_January_26.jpg";
Matcher m = regex.matcher(str);
if (m.find()) {
    String res = m.group(1);
}