private String[] splitString(String s) {
  // returns an OptionalInt with the value of the index of the first Letter
  OptionalInt firstLetterIndex = IntStream.range(0, s.length())
    .filter(i -> Character.isLetter(s.charAt(i)))
    .findFirst();

  // Default if there is no letter, only numbers
  String numbers = s;
  String letters = "";
  // if there are letters, split the string at the first letter
  if(firstLetterIndex.isPresent()) {
    numbers = s.substring(0, firstLetterIndex.getAsInt());
    letters = s.substring(firstLetterIndex.getAsInt());
  }

  return new String[] {numbers, letters};
}