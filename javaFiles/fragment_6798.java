String regex = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";
String str = "+123-9854875847";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(str);
if (m.matches())
{
   System.out.println("Country = " + m.group(1));
   System.out.println("Data = " + m.group(2));
}