int shift = 2;
String str = "nick";
int pos = str.length() - shift;

// outputs 'ckni'
System.out.println(str.substring(pos, str.length()) + str.substring(0, pos));