final String regex = "(\\w[\\w\\s]{9})(\\d)(.+?(?=\\w[\\w\\s]{9}\\d|$))";
final String string = "fieldOne  5abcdefieldTwo  3abcfieldThree6abcdef";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.printf("Field: <%s> Len: <%d> Value: <%s>%n",
           matcher.group(1).trim(), matcher.group(2), matcher.group(3));
}