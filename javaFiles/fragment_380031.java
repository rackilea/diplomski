private boolean isSwearWord( final String w ) {
    List<String> ls = generateAllPermutationsWithLevenhsteinEditDistanceOne(w);
    for ( final String cand : ls ) {
        if ( s.contains( cand.toLowerCase()) ) {
            return true;
        }
    }
    return false;
}