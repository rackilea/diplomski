private static int[] reverseArray (int[] arr)

{
    if(arr.length == 1){
        return arr;
    }
    else{
        int temp = arr[0];
        int tempArr[] = new int[arr.length-1];
        System.arraycopy(arr, 1, tempArr, 0, tempArr.length);
        tempArr = reverseArray(tempArr);
        System.arraycopy(tempArr, 0, arr, 0, tempArr.length);
        arr[arr.length-1] = temp;
        return arr;
    }
}