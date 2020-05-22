Set<String> uniqueLines = new HashSet<String>();
String line = readLine();
if (!uniqueLines.contains(line)) {
   write_to_file(line);
   uniqueLines.add(line);
}