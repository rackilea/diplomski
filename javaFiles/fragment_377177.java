public static boolean isBalanced(String s) {
        int sOpen = 0;
        int rOpen = 0;
        for(int i = 0; i < s.length() - 1; ++i) {
            final char current = s.charAt(i);
            final char next = s.charAt(i + 1);
            if(!isValidSymbol(current, next)) {
                return false;
            }
            if(current == '(') rOpen++;
            else if(current == '[') sOpen++;
            else if(current == ')') rOpen--;
            else if(current == ']') sOpen--;
            if(rOpen < 0 || sOpen < 0) return false;
        }
        final char lastChar = s.charAt(s.length() - 1);
        if(lastChar == '(') rOpen++;
        else if(lastChar == '[') sOpen++;
        else if(lastChar == ')') rOpen--;
        else if(lastChar == ']') sOpen--;

        return s.length() > 1 && rOpen == 0 && sOpen == 0;
    }

    private static boolean isValidSymbol(char from, char to) {
        if(from == '(') {
            return to == ')' || to == '['  || to == '(' ;
        }
        else if(from == '[') {
            return to == ']' || to == '(' || to == '[';
        }
        return true;        
    }


public static void main(String[] args) {
        String testInput = "()[]";
        assert isBalanced(testInput) : "expected true";

        testInput = "([)]";
        assert isBalanced(testInput) == false : "expected false";

        testInput = "[([([()])])]";
        assert isBalanced(testInput) : "expected true";


        testInput = "([()([])()][()(())]())";
        assert isBalanced(testInput) : "expected true";

        testInput = "([()([])())[()(())]()) ";
        assert isBalanced(testInput) == false : "expected false";

    }