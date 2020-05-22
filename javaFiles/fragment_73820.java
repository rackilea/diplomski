public static boolean contains(int[] arr, int item) {
    // Count of number of occurences
    int count=0;

    for (int i = 0; i < arr.length; i++) {
    if(arr.length-1 == i){
        if(arr[i] == item)
          count++;
     }else {
        if (arr[i] == item &&  arr[i] + 1 == item)
            return false;
        if(arr[i] == item)
            count++;
           }
        }
       return count == 3;
    }