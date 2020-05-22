List<String> ll = new LinkedList<>();
StringBuilder sb = new StringBuilder();
for (char ch : s.toCharArray()) { // <-- String toCharArray
  if (ch != ' ') {
    sb.append(ch); // <-- not a space.
  } else {
    if (sb.length() > 0) { // <-- add non zero length strings to List
      ll.add(sb.toString());
      sb.setLength(0);
    }
  }
}
// Add the last of the buffer
if (sb.length() > 0) {
  ll.add(sb.toString());
}