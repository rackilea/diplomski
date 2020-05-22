String decodedMorseTable = "....x.x.-..x.-..x---xx...x-x.-x-.-.x-.-x---x...-x.x.-.x..-.x.-..x---x.--";
StringBuilder decodedText = new StringBuilder();
String[] words = decodedMorseTable.split("xx");
for (String word : words) {
    String[] splitLetters = word.split("x");
    for (String letter : splitLetters) {
        for (Map.Entry<Character, String> entry : morseCode.entrySet()) {
            if (entry.getValue().equals(letter))
                decodedText.append(entry.getKey());
        }
    }
    decodedText.append(" ");
 }