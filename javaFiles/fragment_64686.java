Pattern p = Pattern.compile("(\\d+) (\\.+)");
Matcher m = p.matcher("5 soy milk");

if (m.matches())
{
  String qty = m.group(1);
  String name = m.group(2);
}