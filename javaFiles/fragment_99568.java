String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
ArrayList<Character> possibleLetters = new ArrayList<Character>(alphabet.length);
for (char c : alphabet) possibleLetters.add(c);
Collections.shuffle(possibleLetters); // optionally: shuffle(possibleLetters, number)

for (int j = 0; i < 5; j++) {
    String letter = possibleLetters.get(j);
}