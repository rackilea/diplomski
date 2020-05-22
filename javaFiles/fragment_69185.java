String text = "word1_word2_word3_word4_word5_word6_word7";
String regex = "(?=(?:_|^)([^_]+_[^_]+))";

Matcher matcher = Pattern.compile(regex).matcher(text);

while (matcher.find()) {
     System.out.println(matcher.group(1));
}