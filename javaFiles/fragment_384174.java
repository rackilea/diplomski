public boolean contains( String strToCheck, char strContent ) {
    // return strToCheck.contains(strContent);

    for( int i = 0; i < strToCheck.length(); i++ ) {
        if( strToCheck.charAt(i) == strContent ) {
            return true;
        }
    }

    return false;
}