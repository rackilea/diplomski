private static final Map<String, Character> morseCode;
static {
    morseCode = new HashMap<>();
    morseCode.put("....", 'h');
    morseCode.put(".", 'e');
    morseCode.put("", ' ');
...   


String[] splitLetters = word.split("x");
for (String letter : splitLetters) {
    decodedText.append(morseCode.get(letter));
}