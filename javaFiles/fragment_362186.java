public boolean isJavaFile(String str1) {
    String str="";
    for(int i=str1.length()-1; i >=0; i--){
        char ch = str1.charAt(i);
        if(ch=='.') {
            str=str+ch;            
            break;
        }
        else
            str=str+ch;            
    }

    if(str.equals("avaj."))
        return true;
    return false;        
}