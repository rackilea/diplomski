public static boolean checkForUnique(String str){
    boolean containsUnique = false;

    for(char c : str.toCharArray()){
        if(str.indexOf(c) == str.lastIndexOf(c)){
            containsUnique = true;
        } else {
            containsUnique = false;
        }
    }

    return containsUnique;
}