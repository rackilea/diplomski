String sentence = "This is a string";
String[] words = sentence.split(" ");
String invertedSentece = "";
for (String word : words){
    String invertedWord = "";
    for (int i = word.length() - 1; i >= 0; i--)
        invertedWord += word.charAt(i);
    invertedSentece += invertedWord;
    invertedSentece += " ";
}
invertedSentece.trim();