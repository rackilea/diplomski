String str = "\"Sample text, another sample\",\"勾\",\"\",\"勾\"";
Pattern pattern = Pattern.compile("\"([^\"]*)\"");
Matcher matcher = pattern.matcher(str);
while(matcher.find())
{
    System.out.println(matcher.group(1));
}