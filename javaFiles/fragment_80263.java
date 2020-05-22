String inputString = ....
String[] keywords = ....

StringBuilder sb = new StringBuilder();
for(String keyword: keywords)
  sb.append("(?<= )").append(keyword).append("(?=[ .,!/?])").append("|");
sb.setLength(sb.length() - 1); //Removes trailing "|". Assumes keywords.size() > 0.

Pattern p = Pattern.compile(sb.toString());
Matcher m = p.matcher(inputString);
int count = 0;
while (m.find())
  count++;