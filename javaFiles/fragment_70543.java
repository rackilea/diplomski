public int[] mergeArrays2(int[] arr1, int[] arr2){
    int[] merged = new int[arr1.length + arr2.length];
    System.arraycopy(arr1, 0, merged, 0, arr1.length);
    System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);

    Set<Integer> nodupes = new HashSet<Integer>();

    for(int i=0;i<merged.length;i++){
        nodupes.add(merged[i]);
    }

    int[] nodupesarray = new int[nodupes.size()];
    int i = 0;
    Iterator<Integer> it = nodupes.iterator();
    while(it.hasNext()){
        nodupesarray[i] = it.next();
        i++;
    }



    return nodupesarray;
}