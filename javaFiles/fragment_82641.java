String str = "word3 word2 word3 word4 word5 word3 word7 word8 word9 word10";
String[] words = str.split("\\W+"); for (int i = 0; i < words.length; i++) {
    // Iterate in an inner loop for nearby elements if "word5" is found.
    if (words[i].equals("word5"))
        for (int j = Math.max(0, i - 3); j < Math.min(words.length, i + 3); j++)
            if (words[j].equals("word3")) {
                // Do something with words[j] to show that you know it exists.
                // Or use it right here instead of assigning this debug value.
                words[j] = "foo";
            }
}
// Prints the result. for (final String word : words) System.out.println(word);