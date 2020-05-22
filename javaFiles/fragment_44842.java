String source = "<input id = \"g\" />"; 
Pattern p = Pattern.compile("\\bid\\s*=\\s*\"([^\"]*)\"");
Matcher m = p.matcher(source);
if (m.find())
{
  System.out.printf("Found 'id' attribute '%s' at position %d%n",
                    m.group(1), m.start());
}