final String w = "world";
String a = "hello " + w;
String b = "hello world";
String c = w;
String d = "hello " + c;
System.out.prinlnt(a == b); // these are the same String
System.out.prinlnt(c == b); // these are NOT the same String