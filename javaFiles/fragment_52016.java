public static int isSorted(int[] intArray) {

    int end = intArray.length-1;
    int counterAsc = 0;
    int counterDesc = 0;

    for (int i = 0; i < end; i++) {
        if(intArray[i] < intArray[i+1]){
            counterAsc++;
        }
        else if(intArray[i] > intArray[i+1]){
            counterDesc++;
        }
    }
    if(counterDesc == 0){
        return 1;
    }
    else if(counterAsc == 0){
        return -1;
    }
    else return 0;
}