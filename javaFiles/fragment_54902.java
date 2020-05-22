public static ArrayList<Character> getCharsThatFollowPattern (String text, String pattern) {

  ArrayList<Character> characters = new ArrayList<Character>();
  int index = text.indexOf(pattern);  
  while (index >= 0) {
    if (index + pattern.length() < text.length()) {
       characters.add(text.charAt(index + pattern.length()));
    }
    index = text.indexOf(pattern, index + 1);  
  }      

  return characters;
}