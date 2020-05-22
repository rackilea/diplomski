String a = "This is a #sample #twitter text of @tom_cruise with a link http://www.google.com";

Pattern mentionPattern = Pattern.compile("(@[A-Za-z0-9_-]+)");
Pattern hashtagPattern = Pattern.compile("(#[A-Za-z0-9_-]+)");
Pattern urlPattern = Patterns.WEB_URL;

StringBuffer sb = new StringBuffer(a.length());
Matcher o = hashtagPattern.matcher(a);

while (o.find()) {
    o.appendReplacement(sb, "<font color=\"#437C17\">" + o.group(1) + "</font>");
}
o.appendTail(sb);

Matcher n = mentionPattern.matcher(sb.toString());
sb = new StringBuffer(sb.length());

while (n.find()) {
    n.appendReplacement(sb, "<font color=\"#657383\">" + n.group(1) + "</font>");
}
n.appendTail(sb);

Matcher m = urlPattern.matcher(sb.toString());
sb = new StringBuffer(sb.length());

while (m.find()) {
    m.appendReplacement(sb, "<font color=\"#EDDA74\">" + m.group(1) + "</font>");
}
m.appendTail(sb);

textView.setText(Html.fromHtml(sb.toString()));