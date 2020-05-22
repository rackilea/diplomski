public String outPutPath(String path) {
    String returnPath;
    for(int i=path.length()-2; i>=0;i--) {
        if(String.toChar(path.charAt(i))=='\\' && path.charAt(i-1)=='\\') {
            int tempt=i;
            break;
        }
    }       
    returnPath=path.subString(0,i+1)+"test";
    return returnPath;
}