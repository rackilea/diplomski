public static boolean validSSN(String s){
    // don't bother doing anything else if the length is wrong
    if (s.length() != 11) { return false; } 
    else {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            // now that you have c, use it. Don't do s.charAt(i) again.

            // if index is both {not 3 AND not 6} do...
            if ((i != 3) && (i != 6)) {

                // you don't need to check "isDigit(s.charAt(i))==false"
                if (!isDigit(c)) { return false; } // if not numeric, return false
            }
            // here we are either index i=3 OR i=6, so if c is not a dash return false
            else if (!isDash(c)) { return false; }
        }
        // at this point we exhausted our loop and couldn't 
        // find anything false, so return true
        return true;        
    }
}