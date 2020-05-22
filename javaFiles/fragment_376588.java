// Initialize some helper structures:
private static Map<Character, Character> CLOSE_TO_OPEN;
private static Set<Character> OPENERS;
static {
    CLOSE_TO_OPEN = new HashMap<>();
    CLOSE_TO_OPEN.put(')', '(');
    CLOSE_TO_OPEN.put(']', '[');
    CLOSE_TO_OPEN.put('}', '{');
    OPENERS = new HashSet<>(closeToOpen.values());
}

public static boolean braces (String str) {
    Stack<Character> stack = new Stack<>();
    for (Character c : str.toCharArray()) {

        // If it's an opening bracket, push it to the stack
        if (OPENERS.contains(c)) {
            stack.push(c);
        } 
        // If it's a closing bracket, check the last opener
        else if (CLOSE_TO_OPEN.containsKey(c)) {
            try {
                Character opener = stack.pop();
                // Handle mismatches brackets
                if (!CLOSE_TO_OPEN.get(c).equals(opener)) {
                    return false;
                }
            } 
            // If the stack is empty, there's a redundant closer
            catch (EmptyStackException ignore) {
                return false;
            }
        }
    }

    // If the stack isn't empty once we're done with the string, 
    // there are redundant openers
    if (!stack.empty) {
        return false
    }
    return true;
}