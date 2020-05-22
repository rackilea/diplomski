Pattern p = Pattern.compile("@tag\\s+([^:]++):\\s*(.*)");
Matcher m = p.matcher(s);
if (m.find())
{
  String[] parts = m.group(1).split("\\s+");
  for (String part : parts)
  {
    System.out.println(part);
  }
}
System.out.printf("message: %s%n", m.group(2));