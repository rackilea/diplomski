public static boolean myContains(String s1, String s2) {

    if (s1 == null || s2 == null)
        return false;

    /*  This should be your win condition without adding any more parameters to the method
     *  If it reaches this line, it means one of two things.
     *  1) That s2 is an empty string, in which case s1 will off course contain it.
     *  or
     *  2) That s2 has matched all of its characters with s1, 
     *  and consequently has been sub-stringed till it was empty. 
     */
    if (s2.isEmpty())
        return true;

    /*  If s1 is empty, then it means that the program has looked through all of the char's in it
     *  and has not been able to match all of s2.
     */
    if (s1.isEmpty())
        return false;

    /*  Here, we want to examine if the sentence starts with the first char of the letters
     *  If it does, then we will recursively call the function
     *  and remove the first char in both strings with the substring function.
     */
    if (s1.charAt(0) == s2.charAt(0))
        return myContains(s1.substring(1), s2.substring(1));

    /* Finally, if the code as made it down here, we should move the sentence down one letter.
     * However we don't want to progress the letters string, as there was no match
     */
    return myContains(s1.substring(1), s2);

}