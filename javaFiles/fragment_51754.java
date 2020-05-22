public static int[] increment(int []array){
    int[] toRet = new int[array.length];
    for(int i=0; i<array.length; i++){
    toRet[i] = array[i]+1;
}
    return toRet;

}