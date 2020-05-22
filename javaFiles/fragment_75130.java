String s = "Hello";
byte[] b = s.getBytes();
for (int i = 0; i < b.length; i++) {
    b[i] = (byte)(~b[i] + 1);
}
// Show the negated bytes
System.out.println(Arrays.toString(b));
String s2 = new String(b);
// Show the bytes of the string constructed from them; note they're not the same
System.out.println(Arrays.toString(s2.getBytes()));