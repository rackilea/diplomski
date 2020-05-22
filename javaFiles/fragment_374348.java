final String regex = "(?<!\\S)(inn)|([^aeiou\\r\\n])\\2+";
final String string = "asso\n"
     + "assso\n"
     + "assocco\n"
     + "innasso";
final String subst = "$1$2";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

final String result = matcher.replaceAll(subst);

System.out.println(result);