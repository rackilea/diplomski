// Compile the pattern
Pattern p = Pattern.compile("\\\\u([0-9a-f]{4})");
// Create a matcher for our input
Matcher m = p.matcher(testString);
// Create a buffer to hold the resulting string
StringBuffer result = new StringBuffer();
// Iterate over matches
while(m.find()) {
  // Convert to UTF8 characters
  int codePoint = Integer.parseInt(m.group(1), 16);
  char[] chars = Character.toChars(codePoint);
  // Append to buffer
  m.appendReplacement(result, new String(chars));
}
// Append rest of string
m.appendTail(result);
// Display result
System.out.println(result);