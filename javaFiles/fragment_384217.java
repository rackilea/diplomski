class CharSwitchChecker implements Checker {
    @Override
    public boolean contains(String s) {
        final int length = s.length();
        if (length < 3 || length > 5)
            return false;

        switch (s.charAt(0)) {
        case 'z':
            return "zero".equals(s);
        case 'o':
            return "one".equals(s);
        case 't':
            return s.charAt(1) == 'w' ? "two".equals(s) : "three".equals(s);
        case 'f':
            return s.charAt(1) == 'o' ? "four".equals(s) : "five".equals(s);
        case 's':
            return s.charAt(1) == 'i' ? "six".equals(s) : "seven".equals(s);
        case 'e':
            return "eight".equals(s);
        case 'n':
            return "nine".equals(s);
        }
        return false;
    }
}