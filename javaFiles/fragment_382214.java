StringBuilder reversedSentence = new StringBuilder();

for (int i = words.length - 1; i > 0; i--) {
    reversedSentence.append(words[i]).append(' ');
}
reversedSentence.append(words[0]);
System.out.println('"' + reversedSentence.toString() + '"');