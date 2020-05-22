Pattern p = Pattern.compile("node \\[\\n([^\\]]*)\\]", Pattern.MULTILINE);
Matcher m = p.matcher(text);
while(m.find())
{
    System.out.println(m.group(1));
}