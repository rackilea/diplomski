public static boolean isMember(int[] array, int value) {
    if(array.length == 0) return false; 
    if(array[0] == value) return true;
    int[] array2 = new int[array.length-1];
    System.arraycopy(array,1,array2,0,array2.length);
    return isMember(array2, value);           
}