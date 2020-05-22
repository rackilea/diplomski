public static String addBs(String sentence, String word) { 
    StringBuilder result = new StringBuilder();
    String[] words = sentence.trim().split("\\s");
    for(String wordInSentence: words) {
      if(wordInSentence.equals(word)) {
        result.append("<b>").append(word).append("</b> ");
      }  else {
        result.append(wordInSentence).append(" "); 
      }
    }
    return result.toString();
  }
}