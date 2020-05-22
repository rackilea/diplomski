String a = "foo"; // this string will be interned
String b = "foo"; // interned to the same string as a
boolean c = a == b; //this will be true
String d = new String(a); // this creates a new non-interned String
boolean e = a == d; // this will be false
String f = "f";
String g = "oo";
String h = f + g; //this creates a new non-interned string
boolean i = h == a // this will be false
File fi = ...;
BufferedReader br = ...;
String j = br.readLine();
boolean k = a == j; // this will always be false. Data that you've read it is not automatically interned