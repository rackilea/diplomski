String line = "unknownXoooXNOUNXccccccXunknown";
String regex = "Xo+X(.*?)Xc+X";

Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(line);
if (m.find()) {
   String noun = m.group(1);
}