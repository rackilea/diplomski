String input = "abcd";
Pattern regex = Pattern.compile("\\w{2}");
Matcher matcher = regex.matcher(input);
while (matcher.find()){//this will try to find single match
     System.out.println(matcher.group());
}