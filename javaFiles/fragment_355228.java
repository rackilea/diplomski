final String regex = "(?!\\bi+\\b)\\b[dcmlxvi]+\\b|(\\bi+\\.)";
String string = "i i Both ix is viii are roman numeral. mcmlxxxvii is wow year. Year is mmxvi. i i I i i i i am good";
String tmp;
final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    tmp=matcher.group(0).toUpperCase();
    string=string.replace(matcher.group(0),tmp);
}

System.out.println(string);