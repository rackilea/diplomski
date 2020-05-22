StringBuilder sb = new StringBuilder();
String separator = "";
for (String string : iterable) {
  sb.append(separator);
  sb.append(string);
  separator = ", ";
}