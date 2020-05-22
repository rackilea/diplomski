class RefOrChecker extends OrChecker {
    @Override
    public boolean contains(String s) {
        return "zero" == s || "one" == s || "two" == s || "three" == s
                || "four" == s || "five" == s || "six" == s || "seven" == s
                || "eight" == s || "nine" == s || super.contains(s);
    }
}