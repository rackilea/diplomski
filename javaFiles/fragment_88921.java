String s = "\\[\\sqrt 3\\]";
System.out.println(s);
Matcher m = Pattern.compile("\\\\\\[(.*?)\\\\\\]").matcher(s);
while(m.find())
{
    System.out.println(m.group(1));
}