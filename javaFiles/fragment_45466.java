public boolean containsLetter(String s) {
    if ( s == null)
        return false;

    for (int i = 0;  i < s.length(); i++){
        if(CharacterUtilities.isLetter(s.charAt(i)))
            return true;
    }
    return false;
}