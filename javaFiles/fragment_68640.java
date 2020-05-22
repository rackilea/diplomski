int len = bytes.length();
int aLength;
String a, b;
for(int i=0; i<len; i++) {
  a = bytes[i];
  aLength = a.length();
  for(int j=i; j<len; j++) {
    b = bytes[j];
    if (b.length() + aLength == targetLength) {
      validSolutions.add(b.concat(a));
      validSolutions.add(a.concat(b));
    }
  }
}