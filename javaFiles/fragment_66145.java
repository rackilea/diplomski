byte[] b = null;
String s = new String(b); // complier should be fine with this

char[] c = null;
String s = new String(c); // complier should be fine with this

.... // you can try other constructors using similar approach.