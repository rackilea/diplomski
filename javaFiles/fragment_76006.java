String str = "abc asf basdfasf asf";
Matcher matcher = Pattern.compile("\\S+").matcher(str);

while (matcher.find()) {
    System.out.println(matcher.start() + ":" + matcher.group());
}