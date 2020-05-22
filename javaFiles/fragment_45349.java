private static int[] sort(int[] arr){
    int[] secondArray = new int[arr.length];
    for (int i=0; i < arr.length; i++){
        secondArray[i] = arr[i];
    }

    return Arrays.sort(secondArray);
}