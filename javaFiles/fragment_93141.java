int frownyFace = 0x2639;
String s = Character.toString((char)frownyFace);
System.out.println(s);
// Turn that frown upside down!
s = Character.toString((char)(s.codePointAt(0) + 1));
System.out.println(s);