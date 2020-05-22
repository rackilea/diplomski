// One possible way of creating your list
// Reset your list within each "i" loop, just before the "j" loop, 
//   or you'll never repeat letters across rows
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
ArrayList<Character> possibleLetters = new ArrayList<Character>(alphabet.length);
for (char c : alphabet) possibleLetters.add(c);

// now select randomly "without replacement"
for (int j = 0; i < 5; j++) {
    int index = number.nextInt(possibleLetters.size());
    String letter = possibleLetters.remove(index);
}