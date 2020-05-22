String bits = Long.toString(someLong, 2);
StringBuilder sb = new StringBuilder();

for (int toPrepend=10-str.length(); toPrepend>0; toPrepend--) {
    sb.append('0');
}
sb.append(bits);
String output = sb.toString();