List<String> result = new ArrayList<String>();
String input = "[dgdds,dfse][fsefsf,sefs][fsfs,fsef]";
Pattern pattern = Pattern.compile("\\[.*?\\]");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) 
{
    result.add(matcher.group());
}
System.out.println(result);