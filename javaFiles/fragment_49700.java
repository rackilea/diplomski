final Pattern p = Pattern.compile("[^/]/");
final String s = "/accounts/main/index/page.xhtml";
final Matcher m = p.matcher(s);
final List<String> resultList = new ArrayList<String>();
while (m.find()) {
    resultList.add(s.substring(0, m.end()));
}
final String[] resultArr = resultList.toArray(new String[resultList.size()]);