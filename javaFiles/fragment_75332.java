Pattert p = Patter.compile("(\\w+):(\\w+):");
Matcher m = p.matcher(str);
if (m.find()) {
   String a = m.group(1);
   String b = m.group(2);
}