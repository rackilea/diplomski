String  text    = "asdf 2013-05-12 asdf";
String  regex   = ".+?([0-9]{4}\\s?-\\s?[0-9]{2}\\s?-\\s?[0-9]{2}).+";
Matcher matcher = Pattern.compile(regex).matcher(text);

if (matcher.matches()) {
    String matchedGroup = matcher.group(1);
    System.out.println(matchedGroup);
}