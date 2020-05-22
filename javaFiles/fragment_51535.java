String paragraph = "I ate an apple, but I am still hungry, so I will eat pie";
List<String> wordList = Arrays.asList("apple","hungry","pie");
Pattern p = Pattern.compile("\\b(?:" + String.join("|", wordList) + ")\\b");
Matcher m = p.matcher(paragraph);
if (m.find()) {  // To find all matches, replace "if" with "while"
    System.out.println("Found " + m.group()); // => Found apple
}