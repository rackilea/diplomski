public static <T extends Comparable<T>> T getMax(T[] array){
    T max=array[0];
    for(int x=0; x<array.length;x++){
        if(array[x].compareTo(max)==1)
            max=array[x];
    }
    return max;
}