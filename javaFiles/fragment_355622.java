String s = "#!key1 #!compound.key2 #!super.compound.key3";
Matcher matcher = Pattern.compile("(?<=#!)\\w+(?:\\.\\w+)*").matcher(s);
while (matcher.find()) {
    System.out.println(matcher.group());
}
// => [key1, compound.key2, super.compound.key3]