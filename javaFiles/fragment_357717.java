Pattern p = Pattern.compile("location in \\((.*?)\\)");
Matcher m = p.matcher(conditions);
if (m.find())
{
    String s = m.group(1);
}