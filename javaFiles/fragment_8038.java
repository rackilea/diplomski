char[] answerStringChars = answerString.toCharArray();
for (int i = 0; i < answerString.length(); i++) {
    if (input.charAt(i) == guessChar) {
        answerStringChars[i] = guessChar;
    }
}
String newAnswerString = String.valueOf(answerStringChars);