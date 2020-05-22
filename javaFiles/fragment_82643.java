Pattern pattern = Pattern.compile("word3(?=(?:\\W*\\w++){0,2}?\\W*+word5)|(word5(?:\\W*\\w++){0,2}?\\W*+)word3");
Matcher matcher;
String str = "word3 word2 word3 word4 word5 word3 word7 word8 word9 word10";
while ((matcher = pattern.matcher(str)).find())
    // Do something with matcher.group(1) to show that you know it exists.
    // Or use it right here instead of replacing with this empty value.
    str = matcher.replaceFirst(matcher.group(1) == null ? "" : matcher.group(1));
System.out.println(str);