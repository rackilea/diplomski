class OrChecker implements Checker {
    @Override
    public boolean contains(String s) {
        return "zero".equals(s) || "one".equals(s) || "two".equals(s)
                || "three".equals(s) || "four".equals(s) || "five".equals(s)
                || "six".equals(s) || "seven".equals(s) || "eight".equals(s)
                || "nine".equals(s);
    }
}