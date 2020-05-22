boolean checkParentheses(String str) {
    Deque<Character> stack = new ArrayDeque<>();

    String k = "({[";
    String s = ")]}";
    for (int i = 0; i < str.length();i++ ) {
        if (k.indexOf(str.charAt(i)) > -1) {
            stack.push(str.charAt(i));
        } else if (s.indexOf(str.charAt(i)) > -1) {

            if (matching(stack.peek()) == str.charAt(i)) {
                return true;
            }
        } else {
            return false;
        }
    }
    return false;
}