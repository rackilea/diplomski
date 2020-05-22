String[] lines = text.split("\n");
StringBuilder buffer = new StringBuilder();
for (String line : lines) {
   buffer.append(line.trim());
   buffer.append("\n");
}
String result = buffer.toString();