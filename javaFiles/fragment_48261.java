List<String> array = new ArrayList<String>();
StringBuilder buf = new StringBuilder();
for (String line : lines) {
  if (line.startsWith(">")) {
    if (buf.length() > 0) {
      array.add(buf.toString());
      buf.setLength(0);
    }
  } else {
    buf.append(line);
  }
}
if (buf.length() > 0) { // Add the final text element(s).
  array.add(buf.toString());
}