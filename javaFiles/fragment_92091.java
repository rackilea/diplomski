String totalCharacters = "";
if (passwordABCD.isSelected()) {totalCharacters += capitalLetters;}
if (passwordabcd.isSelected()) {totalCharacters += lowercaseLetters;}
if (password0123.isSelected()) {totalCharacters += numbers;}
if (passwordSymbols.isSelected()) {totalCharacters += characters;}
if (totalCharacters.isEmpty()) {
    throw new IllegalArgumentException("At least one kind of symbols required.");
}
if (length == 0) {
    throw new IllegalArgumentException("Empty password not allowed.");
}

char[] text = new char[length];
for (int i = 0; i < length; i++) {
    text[i] = totalCharacters.charAt(rand.nextInt(totalCharacters.length()));
}
return new String(text);