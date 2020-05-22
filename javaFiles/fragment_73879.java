String lineFromFile = bufferedReader.readLine();
// strip out the `[` and `]`
lineFromFile = lineFromFile.substring(1, lineFromFile.length()-1);
StringBuilder sb = new StringBuilder();
for(String s: lineFromFile.split(", "))
    sb.append((char) Integer.parseInt(s));
String text = sb.toString();