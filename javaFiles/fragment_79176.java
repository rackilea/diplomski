ArrayList<String> lines = new ArrayList<String>();
String line;
while ((line = reader.readLine()) != null) {
    lines.add(line);
}
HashMap<String, String> votes = new HashMap<String, String>();
for(String line: lines) {
    String[] terms = line.split(">");
    votes.put(terms[0], terms[1]);
}