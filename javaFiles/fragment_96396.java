public static String listCountriesOfOrigin (Bowl[] bowls) {
    for(int i = 0; i < bowls.length; i++) {
        String origin = bowls[i].getOrigin();
        return origin;
    }
    // No return here
}