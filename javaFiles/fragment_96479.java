String s = "bla bla {{foo}} bla bla {{bar=hehe}} bla bla";
Matcher m = Pattern.compile("\\{\\{[a-zA-Z0-9_-]*(?:=(?:(?!}}).)*)?\\}\\}").matcher(s);
while(m.find())
{
    System.out.println(m.group());
}