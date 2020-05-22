String str = ...;
OutputStream out = ...;

for (int i = 0; i < str.length; i += 8) {
    String byteStr = str.substring(i, i+8);
    int byteVal = Integer.parseInt(byteStr, 2);
    out.write(byteVal);
}