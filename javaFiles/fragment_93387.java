public static void main(String args[]) {
    String pattern = "abc";
    String letters = "abcdef";

    char[] patternArray = pattern.toCharArray();
    char[] lettersArray = letters.toCharArray();
    boolean matched = false;
    for(int i = 0; i< lettersArray.length-patternArray.length && !matched; i++){
        for(int j = 0; j < patternArray.length;j++){
            if(patternArray[j] == lettersArray[i+j]&&j+1==patternArray.length){
                matched = true;
                System.out.println("true");
            }
            else if(i+1 == lettersArray.length-patternArray.length && j+1 == patternArray.length){
                System.out.println("false");
        }
    }
}