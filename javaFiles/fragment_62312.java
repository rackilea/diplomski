public static boolean isTrans (String s, String t) {
    if (condition)
        return true;
    else 
        return false;
    //the condition must have been true or false so the method has already exited.
    return isTrans(s.substring(1), t);     
}