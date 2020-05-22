String input; // your JSON input
Pattern p = Pattern.compile("\"([A-Z])([^\"]*\"\\s*:)"); // matches '"Xxxx" :'
Matcher m = p.matcher(input);
StringBuffer output = new StringBuffer();
while (m.find()) {
   m.appendReplacement(output, String.format("\"%s$2", m.group(1).toLowerCase());
}
m.appendTail(output);