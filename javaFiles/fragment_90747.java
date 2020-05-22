for(int i = 0; i < 100; i++) {
    boolean even = i % 2 == 0;
    boolean matches = false;

    if(even)
        matches = text.regionMatchesIgnoreCase(...);
    else
        matches = text.regionMatches(...);

    // use matches
}