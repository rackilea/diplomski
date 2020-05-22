List<String> words = new ArrayList<String>();
String s  = "I want to have alot of money's when I am older.";
Pattern p = Pattern.compile("[a-zA-Z']{4,}");
Matcher m = p.matcher(s);
while (m.find()) {
  words.add(m.group());
}
System.out.println(words);

// [want, have, alot, money's, when, older]