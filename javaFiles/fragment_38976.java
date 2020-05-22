String[] words = sentence.split(" "); // splits on the space between words

for (int i = 0; i < words.length; i++) {
    String word = words[i];
    System.out.print(reverseWord(word));

    if (i < words.length-1) {
        System.out.print(" "); // space after all words but the last
    }
}