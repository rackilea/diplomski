String YourString = "Today is a beautiful sunny day #sun. Hello my name is Mat #Sweet#Home";

String REG_EX_TAG = ".*?\\s(#\\w+).*?";

Pattern tagMatcher = Pattern.compile(REG_EX_TAG);
Matcher m = tagMatcher.matcher(YourString);
if(m.find())
{
    String tag = m.group(1);
    // Whatever you want to do with the tag - store it, print it, etc.
}