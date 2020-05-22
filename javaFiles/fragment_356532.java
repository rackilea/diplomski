String s = "Waiting for match #indvspak and #indvsaus";
Matcher m = Pattern.compile("(?<!\\S)#\\S*vs\\S+").matcher(s);
while(m.find())
{
    System.out.println(m.group());
}