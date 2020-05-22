Pattern pattern = Pattern.compile("[^\\S ]");

String a = "a\nb";
String b = "a b";

System.out.println(pattern.matcher(a).find()); // true
System.out.println(pattern.matcher(b).find()); // false