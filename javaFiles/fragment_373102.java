public bool isWriteable(String s){
    char[] chars = s.toCharArray();
    int i;
    char c;
    for (i = 0; i < chars.length; i++){
        if (!isWriteable(c)){
            return false;
        }
    }
    return true;
}