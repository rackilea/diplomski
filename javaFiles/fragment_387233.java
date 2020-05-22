import java.util.regex.*;
...
Pattern targetPattern = Pattern.compile("(?xi)\\b(inventory|finished|goods)\\b");
for (String singleString : listOfWords) {
  if (targetPattern.matcher(singleString).find()) {
    extractedStrings.add(singleString);
  }
}