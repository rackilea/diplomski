List wordList = new ArrayList<String>();
// populate your wordList

// build the regex
String lstr = wordList.toString();
String regex  = lstr.substring(1, lstr.length()-1).replace(", ", "|");

// replacement
String replaced = copyInputString.replaceAll("\\b(" + regex + ")\\b", " ");