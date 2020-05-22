StringBuilder result = new StringBuilder("");
String line;
while ((line = reader.readLine()) != null) { // <---
    result.append(line);
}
in.close();