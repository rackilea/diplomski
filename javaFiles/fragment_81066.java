private void append( final String s, final char[][] chars, final Set<String> candidates ) {
        if ( s.length() >= 2 && doesTrieContainAnyWordStartingWith( s ) ) {
            candidates.add( s + "..." ); // TODO: here add all words starting with 's' instead of adding 's'
        }
        if ( doesTrieContainAnyWordStartingWith( s ) && chars.length > 0 ) {
            final char[][] next = new char[chars.length-1][];
            for (int i = 1; i < chars.length; i++) {
                next[i-1] = chars[i];
            }
            // our three recursive calls, one for each possible letter
            // (you'll want to adapt for a 'real' keyboard, where some keys may only correspond to two letters)
            append( s + chars[0][0], next, candidates );
            append( s + chars[0][1], next, candidates );
            append( s + chars[0][2], next, candidates );
        } else {
            // we do nothing, it's our recursive termination condition and
            // we are sure to hit it seen that we're decreasing our 'chars'
            // length at every pass  
        }
    }

    private boolean doesTrieContainAnyWordStartingWith( final String s ) {
        // You obviously have to change this
        return true;
    }