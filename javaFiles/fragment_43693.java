String str = "[2015-04-09 13:10:27,858] [1428599427721] [{ashwinsakthi@yahoo.com}{SpringFramework}{Host123}{58}{20150409131026660}][getfilesInput] [WebContainer : 2]";
String rx = "[\\[{]+([^\\]}]*?)[\\]}]+";
Pattern ptrn = Pattern.compile(rx);
Matcher m = ptrn.matcher(str);
while (m.find()) {
   System.out.println(m.group(1));
}