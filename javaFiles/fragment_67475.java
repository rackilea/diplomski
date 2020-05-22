String term = "This iS the teRm.";
String matchText = "123This is the term.";
StringBuilder str = new StringBuilder();
str.append("^[^A-Za-z]*(");
for (int i = 0; i < term.length(); i++) {
  char c = term.charAt(i);
  if (Character.isLetter(c))
    str.append("(" + Character.toLowerCase(c) + "|" + Character.toUpperCase(c) + ")");
  else str.append(c);
}
str.append(")[^A-Za-z]*$");

System.out.println(str.toString());


Pattern p = Pattern.compile(str.toString());
Matcher m = p.matcher(matchText);
if (m.find()) System.out.println("Found!");
else System.out.println("Not Found!");