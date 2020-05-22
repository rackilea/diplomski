public static boolean isAnagram(String s1, String s2) {
    //Create a string buffer of the second string as lower case.
    StringBuffer sb = new StringBuffer(s2.toLowerCase());
    /*
     * Convert all characters of the first string to lowercase.
     * Split the string into an array of char
     * Loop over all chars, the current char is accessible by the variable c.
    */
    for (char c : s1.toLowerCase().toCharArray()) {
        //Character functionallity to check if the current character is a letter
        if (Character.isLetter(c))
        {
            //Retrieve the index of the current char in the second string, -1 will be returned if not found
            int index = sb.indexOf(String.valueOf(c));

            //if not found, we return false.
            if (index == -1) {                    
                return false;
            }

            //Remove the current char from the second string.
            sb.deleteCharAt(index);
        }
    }

    //Loop over all characters of the second string (you should understand this as it is the same logic as the first loop).
    for (char c : sb.toString().toCharArray()) {
        //only allow whitespace as left overs
        if (!Character.isWhitespace(c)) {
            //return false if something else then a whitespace is found
            return false;
        }
    }

    //If we arrive here it means that the algorithm was not able to prove false so we return true.
    return true;
}