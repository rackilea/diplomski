String test = "hello" + "[" + 800 + "]" + "\n" + "world" + "[" + 810 + "]";

String regex="(?<=\\[)\\d+(?=\\])";
Pattern pattern=Pattern.compile(regex);
Matcher matcher=pattern.matcher(test);
while(matcher.find()){
    System.out.println(matcher.group());
}