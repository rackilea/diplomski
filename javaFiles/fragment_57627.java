TreeMap<Integer, Integer> spaces = new TreeMap<Integer, Integer>();
String regex = "(?<=^| )((TOK1|TOK2)( |$))+";
String str = "TOK3 TOK1 TOK2 TOK2 TOK4 TOK3";
int c = 0;
spaces.put(0, 0);
for (int i = 0; i < str.length(); i++)
{
   if (str.charAt(i) == ' ')
     spaces.put(i, ++c);
}
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(str);
while (m.find()) {
   System.out.println(m.group());
   System.out.println("start = " + spaces.floorEntry(m.start()).getValue());
   System.out.println("finish = " + spaces.floorEntry(m.end()).getValue());
}