Matcher m = Pattern.compile("^([\\d_]+)\\D+(\\d+)$").matcher(str);
while(m.find())
{
  System.out.println(m.group(1));
  System.out.println(m.group(2));
}