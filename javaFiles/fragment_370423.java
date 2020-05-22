String line = "name1=gil;name2=orit;";
Pattern p = Pattern.compile("\\G(\\w+)=(\\w+);");
Matcher m = p.matcher(line);
int lastMatchPos = 0;
while (m.find()) {
   System.out.println(m.group(1));
   System.out.println(m.group(2));
   lastMatchPos = m.end();
}
if (lastMatchPos != line.length())
   System.out.println("Invalid string!");