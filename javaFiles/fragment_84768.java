String s = "<amy=amy>(bob=bob)[carol=carol]";
Pattern p = Pattern.compile(
  "(?=[<(\\[]((\\w+)=\\2))(?:<\\1>|\\(\\1\\)|\\[\\1\\])");
Matcher m = p.matcher(s);

while(m.find())
{
  System.out.printf("found %s in %s%n", m.group(2), m.group());
}