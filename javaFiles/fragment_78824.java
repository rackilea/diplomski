java.util.List<String> test(String[] words, String input){
  java.util.List<String> result = new java.util.ArrayList<>();

  // Sort the characters in the input-String:
  byte[] inputArray = input.getBytes();
  java.util.Arrays.sort(inputArray);
  String sortedInput = new String(inputArray);

  for(String word : words){
    // Sort the characters of the word:
    byte[] wordArray = word.getBytes();
    java.util.Arrays.sort(wordArray);
    String sortedWord = new String(wordArray);

    // Create a regex to match from this word:
    String wordRegex = ".*" + sortedWord.replaceAll(".", "$0.*");
    // If the input matches this regex:
    if(sortedInput.matches(wordRegex))
      // Add the word to the result-List:
      result.add(word);
  }

  return result;
}