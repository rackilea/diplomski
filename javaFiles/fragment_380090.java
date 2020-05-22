enum Tokens {
    FOO, BAR, BAZ, AND, A, LOT, MORE // etc …

    /** Special Token End-Of-File */
    EOF {
        @Override
        public boolean matches(String input, int pos) {
            return input.length()==pos;
        }
    };

    // all ordinary tokens have the same behavior
    public boolean matches(String input, int pos) {
        return input.length()-pos >= name().length()
          && input.regionMatches(pos, name(), 0, name().length());
    }
}