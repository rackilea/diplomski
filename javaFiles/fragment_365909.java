String a = "abcdabcd";
String b = "abc";
String c = "abcd";
System.out.println(a.matches(".*" + b + "$")); // false - doesn't match end of a, although clearly is part of it
System.out.println(a.matches(".*" + c + "$")); // true - that's what we want
System.out.println(a.indexOf(c) == 0); // true - returns lowest index