static int mostFreqCharCount(final String word) {
    final int chars[] = new int[256];

    int max = 0;
    for (final char c : word.toCharArray()) {
        chars[c]++;
        if (chars[c] > chars[max]) // find most repetitive symbol in word
            max = c;
    }
    return chars[max];
}

public static void main(final String[] args) {
    System.out.println("Enter any sentence or word combination: ");

    final Scanner kbd = new Scanner(System.in);
    final String myString = kbd.nextLine();
    kbd.close();

    int maxC = 0;
    String result = "";

    final String[] words = myString.split("\\s+");
    for (final String word : words) {
        final int c = mostFreqCharCount(word);
        if (c > maxC) {
            maxC = c;
            result = word;
        }
    }

    if (maxC > 1) // any word has at least 1 symbol, so we should return only 2+
        System.out.println(result);
}