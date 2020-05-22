String str = "this is#test_ :";
Pattern ptrn = Pattern.compile("(?<!\\p{Alnum})test(?!\\p{Alnum})");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.start());
}