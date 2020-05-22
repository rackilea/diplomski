String[] word = {"2'442'031.67" , "9'031.67" , "79'442'031.67", "delivered"};
Pattern pattern = Pattern.compile("'");
for(int i = 0; i < word.length; i++) {
    Matcher matcher = pattern.matcher(word[i]);
    word[i] = matcher.replaceAll(",");
}