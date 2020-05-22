public static int maxNameLength( List<? extends Player> players ) {
    int maxLength = 0;
    for ( Player player : players ) {
        int currLength = player.getName().length();
        if ( currLength > maxLength ) {
            maxLength = currLength;
        }
    }
    return maxLength;
}