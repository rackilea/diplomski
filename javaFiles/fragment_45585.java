static String reverseWords(String input) {
    // My code
    if (input == null || input.length() == 0 || input.length() == 1) return input;
    String words[] = input.split(" ");
    String reverseWord = "";
    for (int pointer = words.length - 1; pointer >= 0; pointer--)
        reverseWord += words [pointer] + " ";
    return reverseWord;
}