String regexDelimiters = "[\\s,\"():;.!?\\-]+";
String inputString = "\"Word\"  some more text.";
String[] arrayOfWords = inputString.replaceAll(
        "^" + regexDelimiters,"").split(regexDelimiters);

for (String s : arrayOfWords)
    System.out.println("'" + s + "'");