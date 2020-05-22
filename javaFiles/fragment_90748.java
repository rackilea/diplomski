for(int i = 0; i < 100; i++) {
    boolean even = i % 2 == 0;
    boolean matches = even ? text.regionMatchesIgnoreCase(...) : text.regionMatches(...);

    // use matches
}