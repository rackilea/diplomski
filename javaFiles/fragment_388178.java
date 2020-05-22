String input = "How to write a regex for words like [[gold]] or [[Archimedes]] in JAVA";
String regex = "\\[\\[(.*?)\\]\\]";
Matcher matcher = Pattern.compile(regex).matcher(input);
int idx=0;
while(matcher.find(idx)){
  String match = matcher.group(1);
  System.out.println(match);
  idx = matcher.end();
}