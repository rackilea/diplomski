// Test string, with the tricky case """", which resolves to
// a length 1 string of single quote "
String line = "Bosh,\"\"\"\",mark@gmail.com,\"3, Institute\",\"83, 1, 2\",1,21";

Pattern pattern = Pattern.compile("\"[^\"]*\"");
Matcher matcher = pattern.matcher(line);

int start = 0;

StringBuilder output = new StringBuilder();

while (matcher.find()) {
  // System.out.println(m.group() + "\n " + m.start() + " " + m.end());
  output
    .append(line.substring(start, matcher.start())) // Append unrelated contents
    .append(matcher.group().replaceAll(",", ";")); // Append replaced string

  start = matcher.end();
}
output.append(line.substring(start)); // Append the rest of unrelated contents

// System.out.println(output);