String str = "String:abc||Element:abc||Value:abc"; // Sample text 1
String str1 = "String:abc||Element:abc"; // Sample text 2
String originalPattern = "Element";
String pattern = String.format("\\|{2}%s[^\\|]+", Pattern.quote(originalPattern));
System.out.println(str.replaceFirst(pattern, ""));
System.out.println(str1.replaceFirst(pattern, ""));