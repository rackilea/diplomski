String s = "    hello there"; // four spaces at beginning of string
String[] sa = s.split(" ");
List<String> ll = new LinkedList<>();
for (String str : sa) {
  if (str.length() > 0) { // <-- check for empty string.
    ll.add(str);
  }
}