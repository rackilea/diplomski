private boolean match(String actualPattern, String patternToMatch) {
    boolean match = true;
    for(int i=0; i<patternToMatch.length(); i++) {
        if(patternToMatch.charAt(i) != '-'
        && patternToMatch.charAt(i) != actualPattern.charAt(i)) {
            match = false;
        }
    }
    return true;
}