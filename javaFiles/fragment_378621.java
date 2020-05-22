Pattern p = Pattern.compile("(?<=Customer\\()[^\\)]*");
String original = "Customer(someContent)";
String Replacement = "NewContent";

Matcher m = p.matcher(original);
String result = m.replaceAll(Replacement);

System.out.println(result);