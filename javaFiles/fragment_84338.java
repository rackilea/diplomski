public static String wordReverse(String[] theWords, Stack<String> stack) {
    // stop on null.
    if (theWords == null) {
        return null;
    } else if (theWords.length < 2) {
        // stop if there are fewer then two words.
        return theWords[0];
    }
    // push the first word.
    stack.push(theWords[0]);
    // copy the sub-array.
    String[] s = new String[theWords.length - 1];
    System.arraycopy(theWords, 1, s, 0, theWords.length - 1);
    // recurse
    return wordReverse(s, stack) + " " + stack.pop();
}

public static String wordReverse(String[] theWords) {
    // call the recursive implementation with a new Stack.
    return wordReverse(theWords, new Stack<String>());
}

public static void main(String args[]) {
    Scanner takeIn = new Scanner(System.in);
    String allWords = takeIn.nextLine();
    String[] goodWords = allWords.split(" ");
    System.out.println(wordReverse(goodWords));
    takeIn.close();
}