List<String> cleanLines = new ArrayList<String>();
for(String line : lines) {
  //replace curly brackets with... nothing.
  //added a call to trim() in order to remove whitespace characters.
  cleanLines.add(line.replaceAll("[{}]","").trim());
}