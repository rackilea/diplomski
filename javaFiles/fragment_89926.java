boolean checkParentheses(String str) {
    Deque<Character> stack = new ArrayDeque<>();

    String k = "({[";
    String s = ")]}";
    for (int i = 0; i < str.length(); i++) {
        if (k.contains(String.valueOf(str.charAt(i)))) {
            stack.push(str.charAt(i));
        } else if (s.contains(String.valueOf(str.charAt(i)))) {

            if (matching(stack.peek()) == str.charAt(i)) {
                return true;
            }
        } else{
            return false;
        }
    }
    return false;
}