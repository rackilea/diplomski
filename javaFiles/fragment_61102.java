// String s = "this*string'has only two@tokens'"; // => [this, stringhas only two@tokens]
String s = "one'two''three' '' four 'twenty-one'"; // => [onetwothree, , four, twenty-one]
Pattern pattern = Pattern.compile("(?:\\w|'[^']*')+", Pattern.UNICODE_CHARACTER_CLASS);
Matcher matcher = pattern.matcher(s);
List<String> tokens = new ArrayList<>();
while (matcher.find()){
    tokens.add(matcher.group(0).replace("'", "")); 
}