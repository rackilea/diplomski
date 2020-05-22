String docToProcess = "... your xml here ...";
Pattern pattern = Pattern.compile(">Part\\s.");
Matcher matcher = pattern.matcher(docToProcess);
StringBuffer output = new StringBuffer();
while (matcher.find()) matcher.appendReplacement(output, "<ref></ref>");
matcher.appendTail(output);