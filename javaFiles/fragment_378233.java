public static String reverseWords(String str) {
    StringBuilder res = new StringBuilder();

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (Character.isSpaceChar(ch)) {
            while (!stack.isEmpty()) res.append(stack.pop());
            res.append(ch);
        } else {
            stack.push(ch);
        }
    }

    // Handle anything left in the stack 
    while (!stack.isEmpty()) {
        res.append(stack.pop());
    }

    return res.toString();
}