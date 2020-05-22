for (int i=1; i<arr.length; i++) {
    Date toInsert=arr[i];
    int j=i;
    while(j>0 && toInsert.compareTo(arr[j-1])<0) {
        arr[j]=arr[j-1];
        j--;
    }
    arr[j]=toInsert;