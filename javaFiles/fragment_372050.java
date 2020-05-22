String regex = "<a href=\"/zamestnanec/\\d+\">(.*?)</a>";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(yourHtml);
while(m.find()){
    System.out.println(m.group(1));
}