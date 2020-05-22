public static List<String> extractUrls(String sms) {
List<String> containedUrls = new ArrayList<String>();
String text = sms;

// Split the sms to analyze if each part is a URL
String[] split = text.split(" ");

Pattern p = Pattern.compile("(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");

// Attempt to convert each item into an URL
for (int i = 0; i < split.length; i++) {
    if (p.matcher(split[i]).matches()) containedUrls.add(split[i]);
}

return containedUrls;
}