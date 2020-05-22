int lengthOfFirstSimilarCharacters(String str1, String str2) {
    int strlen1 = str1.length();
    int strlen2 = str2.length();
    if(strlen1 > strlen2){
        return lengthOfFirstSimilarCharacters(str2,str1);
    }
    int i = 0;
    int j = strlen1-1;
    while(i<=j){
        int mid = i + (j-i)/2;
        if(str1.charAt(mid) == str2.charAt(mid)) {
            if(mid+1<strlen1 && str1.charAt(mid+1) != str2.charAt(mid+1)){
                return mid+1;
            }
            i = mid+1;
        }else{
            j = mid-1;
        }
    }
    return i;
}