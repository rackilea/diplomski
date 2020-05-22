public static int countCurlyBraces(String s, char c) {
    Deque<Character> stack = ...; // I'm assuming 'stack' is some kind of Deque
    int count = 0;
    // doubling memory usage of the string by copying the chars into another array with 's.toCharArray()'
    // for each character in that string...
    for (char cr : s.toCharArray()) {
        // using a stack to keep track if you are inside quotes? just flip a boolean instead
        if (cr == '"')
            if (stack.isEmpty())
                stack.push(cr);
            else
                stack.pop();

        // if inside quotes and the character matches the target, then count it..
        // I thought you wanted to count the characters outside the quotes?
        if (stack.size() == 1 && cr == c)
            count++;
    }

    // iterate through the whole string again and count ALL the characters
    // then subtract the number inside the strings from the total to get the number outside strings
    return StringUtil.countMatches(s, c) - count;
}