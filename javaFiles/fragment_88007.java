StringBuilder builder = new StringBuilder();
for (int i = 0; i < 100000; i++) {
    builder.append((char) i);
}
builder.append("sub_string");
for (int i = 0; i < 100000; i++) {
    builder.append((char) i);
}
String maxString = builder.toString();
long t1 = System.currentTimeMillis();
System.out.println(maxString.contains("sub_string"));
long t2 = System.currentTimeMillis();
System.out.println(t2 - t1);