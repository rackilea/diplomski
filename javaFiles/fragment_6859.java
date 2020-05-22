StringBuilder sb = new StringBuilder();
String[] parts = input.split("\\r?\\n\\r?\\n"); // should be 3 long
// strip out header and newlines from session key
String[] lines = parts[0].split("\\r?\\n");
for (int i = 1; i < lines.length; ++i) { // skip first line
    sb.append(lines[i]);
}
parts[0] = sb.toString();
// strip out header and newlines from message
sb.setLength(0);
lines = parts[1].split("\\r?\\n");
for (int i = 0; i < lines.length; ++i) {
    sb.append(lines[i]);
}
parts[1] = sb.toString();
// finally, deal with the signature
sb.setLength(0);
lines = parts[2].split("\\r?\\n");
for (int i = 0; i < lines.length - 1; ++i) {
    sb.append(lines[i]);
}
parts[2] = sb.toString();