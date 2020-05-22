final Pattern p = Pattern.compile("[^/]/");
final String s = "/accounts/main/index/page.xhtml";
final Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println(s.substring(0, m.end()));
}