// Please excuse any syntax errors, I'm used to C#
Pattern pattern = Pattern.compile("([^ \"]*)|(\"[^\"]*\")");
Matcher matcher = pattern.matcher(theString);
while (matcher.find())
{
    // do something with matcher.group();
}