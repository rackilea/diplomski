public class NumberMatcher {

    private char[] numberChars;
    private int uniqueChars = 0;

    public NumberMatcher(String number, int offset) {
        numberChars = number.toCharArray();
        List<Character> chars = new ArrayList<>();

        for (Character ch : number.substring(offset).toCharArray()) {
            if (!chars.contains(ch)) {
                uniqueChars++;
                chars.add(ch);
            }
        }
    }

    public boolean processMatch(NumberPattern pattern) {
        if (pattern.getWeight() < uniqueChars) {
            return false;
        }

        Character X = null;
        Character Y = null;
        Character Z = null;
        Character A = null;
        Character B = null;
        Character C = null;
        Character D = null;

        final char[] patternChars = pattern.getMaskChars();
        int patternIndex = patternChars.length;
        int numberIndex = numberChars.length;

        while (patternIndex > 0) {
            patternIndex--;
            numberIndex--;
            char numberChar = numberChars[numberIndex];
            char patternChar = patternChars[patternIndex];

            switch (patternChar) {
                case 'A':
                    if (A == null) {
                        A = numberChar;
                        B = (char) (A + 1);
                        C = (char) (B + 1);
                        D = (char) (C + 1);
                    } else if (!A.equals(numberChar)) {
                        return false;
                    }
                    break;
                case 'B':
                    if (B == null) {
                        B = numberChar;
                        A = (char) (B - 1);
                        C = (char) (B + 1);
                        D = (char) (C + 1);
                    } else if (!B.equals(numberChar)) {
                        return false;
                    }
                    break;
                case 'C':
                    if (C == null) {
                        C = numberChar;
                        B = (char) (C - 1);
                        A = (char) (B - 1);
                        D = (char) (C + 1);
                    } else if (!C.equals(numberChar)) {
                        return false;
                    }
                    break;
                case 'D':
                    if (D == null) {
                        D = numberChar;
                        C = (char) (D - 1);
                        B = (char) (C - 1);
                        A = (char) (B - 1);
                    } else if (!D.equals(numberChar)) {
                        return false;
                    }
                    break;
                case 'X':
                    if (X == null) {
                        X = numberChar;
                    } else if (!X.equals(numberChar)) {
                        return false;
                    }
                    break;
                case 'Y':
                    if (Y == null) {
                        Y = numberChar;
                    } else if (!Y.equals(numberChar)) {
                        return false;
                    }
                    break;
                case 'Z':
                    if (Z == null) {
                        Z = numberChar;
                    } else if (!Z.equals(numberChar)) {
                        return false;
                    }
                    break;
                case '.':
                    break;
                case '0':
                    if (numberChar != '0') {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}