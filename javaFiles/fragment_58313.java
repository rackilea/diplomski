StringBuilder output = new StringBuilder("{");
String line = "";
while ((line = br.readLine()) != null) {
  output.append(line);
}
output.append("}");