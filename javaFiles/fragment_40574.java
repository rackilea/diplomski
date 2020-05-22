public static boolean palCheck(char[] a, int index, int start) {
    if (index <= start) { 
        return true; 
    }
    if (a[start] != a[index]){
        return false; //base case
    } else {
        return palCheck (a, index-1, start+1); //recursive step
    } 
}